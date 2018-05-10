package hu.restoffice.dailyclose.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.error.ServiceException.Type;
import hu.restoffice.dailyclose.client.RegisterServiceClient;
import hu.restoffice.dailyclose.domain.EmployeeShiftCloseStub;
import hu.restoffice.dailyclose.domain.RegisterCloseStub;
import hu.restoffice.dailyclose.domain.RegisterDailyCloseStub;
import hu.restoffice.dailyclose.domain.RegisterStub;
import hu.restoffice.dailyclose.domain.RegisterType;
import hu.restoffice.dailyclose.entity.DailyClose;
import hu.restoffice.dailyclose.entity.RegisterDailyClose;
import hu.restoffice.dailyclose.repository.DailyCloseRepository;
import hu.restoffice.dailyclose.repository.RegisterDailyCloseRepository;

/**
 *
 */
@Service
public class DailyCloseServiceImpl {

    private static final Logger log = LogManager.getLogger();

    @Autowired
    RegisterServiceClient registerClient;

    @Autowired
    private DailyCloseRepository dailyCloseRepo;

    @Autowired
    private RegisterDailyCloseRepository registerDailyCloseRpo;

    public Long startDailyClose(final LocalDate dt) throws ServiceException {
        if (!dailyCloseRepo.findByCloseDate(Date.valueOf(dt)).isPresent()) {
            DailyClose dc = new DailyClose();
            dc.setCloseDate(Date.valueOf(dt));
            return dailyCloseRepo.saveAndFlush(dc).getId();

        } else {
            throw new ServiceException(Type.ALREADY_EXISTS, "day already closed", dt);
        }
    }

    @SuppressWarnings("unchecked")
    public List<RegisterDailyCloseStub> closeRegisters(final Long id) throws ServiceException {
        DailyClose dc = dailyCloseRepo.findById(id)
                .orElseThrow(() -> new ServiceException(Type.NOT_EXISTS, "daily close not yet started", id));
        List<RegisterCloseStub> closes = registerClient
                .findClosesesBetweenDate(dc.getCloseDate().toLocalDate(), dc.getCloseDate().toLocalDate()).getBody();
        if (closes == null || closes.size() == 0) {
            throw new ServiceException(Type.NOT_EXISTS, "registers not closed", dc.getCloseDate().toLocalDate());
        }
        List<RegisterStub> registers = registerClient.getRegisters().getBody();
        List<RegisterDailyCloseStub> dailyCloses = aggregateRegisterCloses(closes, registers);
        for (RegisterDailyCloseStub registerDailyCloseStub : dailyCloses) {
            RegisterDailyClose c = new RegisterDailyClose();
            c.setDailyClose(dc);
            c.setType(registerDailyCloseStub.getType());
            c.setCloseTotal(registerDailyCloseStub.getCloseTotal());
            registerDailyCloseRpo.saveAndFlush(c);
        }
        return dailyCloses;

    }

    public Long addShiftClose(final EmployeeShiftCloseStub stub) throws ServiceException {

        return null;
    }

    /**
     * @param closes
     * @param registers
     * @return
     */
    private List<RegisterDailyCloseStub> aggregateRegisterCloses(final List<RegisterCloseStub> closes,
            final List<RegisterStub> registers) {
        List<RegisterDailyCloseStub> rtrn = new ArrayList<>();

        Map<RegisterType, RegisterDailyCloseStub> groups = new HashMap<>();
        for (RegisterType type : RegisterType.values()) {
            groups.put(type, new RegisterDailyCloseStub(null, type, new BigDecimal(0)));
        }

        for (RegisterCloseStub close : closes) {
            RegisterType type = registers.stream()
                    .filter(r -> r.getRegistrationNo().equals(close.getRegisterRegistrationNo())).findFirst().get()
                    .getRegisterType();
            groups.get(type).add(close.getClosingAmount());
        }

        rtrn.addAll(groups.values());
        return rtrn;
    }
}
