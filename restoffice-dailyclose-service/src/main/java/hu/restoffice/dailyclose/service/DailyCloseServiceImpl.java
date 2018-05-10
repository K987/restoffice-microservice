package hu.restoffice.dailyclose.service;

import java.math.BigDecimal;
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

/**
 *
 */
@Service
public class DailyCloseServiceImpl {

    private static final Logger log = LogManager.getLogger();

    @Autowired
    RegisterServiceClient registerClient;

    public Long startDailyClose(final LocalDate dt) throws ServiceException{
        // TODO: ellenőtizni, hogy a dátum létezik-e már, ha nem létrehozni a bejegyzést
        // és lezárni
        if (dt.isEqual(LocalDate.of(2018, 05, 10))) {
            return 1l;
        } else {
            throw new ServiceException(Type.ALREADY_EXISTS, "day already closed", dt);
        }
    }

    @SuppressWarnings("unchecked")
    public List<RegisterDailyCloseStub> closeRegisters(final Long id) throws ServiceException {
        // TODO: id létezik-e már, ha igen elkérni a dátumot és azzal meghívni a feign
        // klienst
        log.info("in service method: " + id);
        if (id == 1) {

            List<RegisterCloseStub> closes = registerClient
                    .findClosesesBetweenDate(LocalDate.of(2018, 05, 15), LocalDate.of(2018, 05, 15)).getBody();
            // TODO: throw exception if empty
            List<RegisterStub> registers = registerClient.getRegisters().getBody();
            // TODO:persist
            return aggregateRegisterCloses(closes, registers);
        } else {
            throw new ServiceException(Type.NOT_EXISTS, "ilyen zárás még nem létezik, id");
        }
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
                    .filter(r -> r.getRegistrationNo().equals(close.getRegisterRegistrationNo()))
                    .findFirst()
                    .get()
                    .getRegisterType();
            groups.get(type).add(close.getClosingAmount());
        }

        rtrn.addAll(groups.values());
        return rtrn;
    }
}
