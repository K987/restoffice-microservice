package hu.restoffice.employee.converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.restoffice.employee.domain.ShiftStub;
import hu.restoffice.employee.entity.Shift;

/**
 *
 */
@Component
public class ShiftConverterServiceImpl implements ShiftConverterService {

    @Autowired
    private EmployeeShiftConverterService converter;
    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.commons.service.DefaultConverterService#from(java.lang.Object)
     */
    @Override
    public ShiftStub from(final Shift entity) {
        LocalDateTime dt = Optional.ofNullable(entity.getStartDateTime()).map(Timestamp::toLocalDateTime).orElse(null);
        return new ShiftStub(entity.getId(), entity.getDuration(), entity.getStartDate(), entity.getStartTime());
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.commons.service.DefaultConverterService#to(java.lang.Object)
     */
    @Override
    public Shift to(final ShiftStub stub) {
        Shift s = new Shift();
        Timestamp dttm = null;
        if (stub.getStartDate() != null && stub.getStartTime() != null) {
            dttm = Timestamp.valueOf(LocalDateTime.of(stub.getStartDate(), stub.getStartTime()));
        }
        s.setStartDateTime(dttm);
        s.setDuration(stub.getDuration());
        return s;
    }

}
