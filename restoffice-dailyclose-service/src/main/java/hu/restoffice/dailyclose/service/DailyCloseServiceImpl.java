package hu.restoffice.dailyclose.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.error.ServiceException.Type;
import hu.restoffice.dailyclose.client.EmployeeServiceClient;
import hu.restoffice.dailyclose.client.EmployeeShiftStub;
import hu.restoffice.dailyclose.client.JobPosition;
import hu.restoffice.dailyclose.client.RegisterServiceClient;
import hu.restoffice.dailyclose.client.RegisterStub;
import hu.restoffice.dailyclose.client.RegisterType;
import hu.restoffice.dailyclose.domain.RegisterCloseStub;
import hu.restoffice.dailyclose.domain.ShiftDailyCloseStub;
import hu.restoffice.dailyclose.entity.DailyClose;
import hu.restoffice.dailyclose.entity.RegisterDailyClose;
import hu.restoffice.dailyclose.entity.ShiftDailyClose;
import hu.restoffice.dailyclose.repository.DailyCloseRepository;
import hu.restoffice.dailyclose.repository.RegisterDailyCloseRepository;
import hu.restoffice.dailyclose.repository.ShiftDailyCloseRepository;

/**
 *
 */
@Service
public class DailyCloseServiceImpl implements DailyCloseService {

    private static final Logger log = LogManager.getLogger();

    @Autowired
    RegisterServiceClient registerClient;

    @Autowired
    EmployeeServiceClient employeeClient;

    @Autowired
    private DailyCloseRepository dailyCloseRepo;

    @Autowired
    private RegisterDailyCloseRepository registerDailyCloseRpo;

    @Autowired
    private ShiftDailyCloseRepository shiftDailyCloseRepo;

    @Override
    public Long startDailyClose(final LocalDate dt) throws ServiceException {
        if (!dailyCloseRepo.findByCloseDate(Date.valueOf(dt)).isPresent()) {
            DailyClose dc = new DailyClose();
            dc.setCloseDate(Date.valueOf(dt));
            return dailyCloseRepo.saveAndFlush(dc).getId();

        } else {
            throw new ServiceException(Type.ALREADY_EXISTS, "day already closed", dt);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<RegisterDailyClose> closeRegisters(final Long id) throws ServiceException {
        DailyClose dc = findById(id);
        List<RegisterCloseStub> closes = registerClient
                .findClosesesBetweenDate(dc.getCloseDate().toLocalDate(), dc.getCloseDate().toLocalDate()).getBody();
        if (closes == null || closes.size() == 0) {
            throw new ServiceException(Type.NOT_EXISTS, "registers not closed", dc.getCloseDate().toLocalDate());
        }

        List<RegisterStub> registers = registerClient.getRegisters().getBody();
        List<RegisterDailyClose> dailyCloses = aggregateRegisterCloses(closes, registers);
        List<RegisterDailyClose> rtrn = new ArrayList<>();
        for (RegisterDailyClose rdc : dailyCloses) {
            rdc.setDailyClose(dc);
            rtrn.add(registerDailyCloseRpo.saveAndFlush(rdc));
        }
        return rtrn;

    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.dailyclose.service.DailyCloseService#getShiftsToClose(java.lang
     * .Long)
     */
    @Override
    public List<ShiftDailyCloseStub> getShiftsToClose(final Long id) throws ServiceException {
        DailyClose dc = findById(id);
        List<EmployeeShiftStub> employees = employeeClient.getEmployeeShiftsOfDay(dc.getCloseDate().toLocalDate())
                .getBody();
        return employees.stream().filter(es -> !es.getActualPosition().getValue().equals(JobPosition.CHEF.getValue()))
                .map(es -> new ShiftDailyCloseStub(null, es.getEmployeeId(), es.getEmployeeName(), new BigDecimal("0"),
                        new BigDecimal("0"), new BigDecimal("0"), id))
                .collect(Collectors.toList());
    }



    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.dailyclose.service.DailyCloseService#closeShifts(java.lang.
     * Long, java.util.List)
     */
    @Override
    public List<ShiftDailyClose> closeShifts(final Long id, final List<ShiftDailyCloseStub> stubs)
            throws ServiceException {
        DailyClose dc = findById(id);
        List<ShiftDailyClose> rtrn = new ArrayList<>();
        for (ShiftDailyCloseStub stub : stubs) {
            ShiftDailyClose sdc = new ShiftDailyClose();
            sdc.setCardTotal(stub.getCardTotal());
            sdc.setCashTotal(stub.getCashTotal());
            sdc.setPosTotal(stub.getPosTotal());
            sdc.setEmployeeName(stub.getEmployeeName());
            sdc.setEmployeeId(stub.getEmployeeId());

            sdc.setDailyClose(dc);
            rtrn.add(shiftDailyCloseRepo.saveAndFlush(sdc));
        }

        return rtrn;

    }

    private DailyClose findById(final Long id) throws ServiceException {
        return dailyCloseRepo.findById(id)
                .orElseThrow(() -> new ServiceException(Type.NOT_EXISTS, "daily close not yet started", id));
    }

    /**
     * @param closes
     * @param registers
     * @return
     */
    private List<RegisterDailyClose> aggregateRegisterCloses(final List<RegisterCloseStub> closes,
            final List<RegisterStub> registers) {
        // List<RegisterDailyCloseStub> rtrn = new ArrayList<>();
        List<RegisterDailyClose> rtrn = new ArrayList<>();

        Map<RegisterType, RegisterDailyClose> groups = new HashMap<>();
        for (RegisterType type : RegisterType.values()) {
            RegisterDailyClose dc = new RegisterDailyClose();
            dc.setType(type);
            dc.setCloseTotal(new BigDecimal("0"));
            groups.put(type, dc);
        }

        for (RegisterCloseStub close : closes) {
            RegisterType type = registers.stream()
                    .filter(r -> r.getRegistrationNo().equals(close.getRegisterRegistrationNo())).findFirst().get()
                    .getRegisterType();
            RegisterDailyClose rdc = groups.get(type);
            rdc.setCloseTotal(rdc.getCloseTotal().add(close.getClosingAmount()));
        }

        rtrn.addAll(groups.values());
        return rtrn;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.dailyclose.service.DailyCloseService#finishCloseDay(java.lang.
     * Long)
     */
    @Override
    public void finishCloseDay(final Long id) throws ServiceException {
        DailyClose dc = findById(id);
        BigDecimal cash = dc.getCardTotal();
        BigDecimal card = dc.getCashTotal();
        BigDecimal pos = dc.getPosTotal();
        for (ShiftDailyClose c : dc.getShiftDailyCloses()) {
            cash = cash.add(c.getCashTotal());
            card = card.add(c.getCardTotal());
            pos = pos.add(c.getPosTotal());
        }
        dc.setCardTotal(card);
        dc.setPosTotal(pos);
        dc.setCashTotal(cash);
        createIncomes(dailyCloseRepo.saveAndFlush(dc));

    }

    /**
     * @param saveAndFlush
     */
    private void createIncomes(final DailyClose dailyClose) {
        Set<RegisterDailyClose> regCloses = dailyClose.getRegisterDailyCloses();

    }
}
