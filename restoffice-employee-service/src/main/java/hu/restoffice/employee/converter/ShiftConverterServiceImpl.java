package hu.restoffice.employee.converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.restoffice.employee.domain.EmployeeShiftStub;
import hu.restoffice.employee.domain.ShiftStub;
import hu.restoffice.employee.entity.EmployeeShift;
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
        return new ShiftStub(entity.getId(), entity.getDuration(), dt,
                fromEmployeeShfifts(entity));
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
        s.setStartDateTime(Optional.ofNullable(stub.getStartDateTime()).map(dt -> Timestamp.valueOf(dt)).orElse(null));
        s.setDuration(stub.getDuration());
        return s;
    }

    /**
     * @param entity
     * @return
     */
    private List<EmployeeShiftStub> fromEmployeeShfifts(final Shift entity) {
        if (!Hibernate.isInitialized(entity.getEmployeeShifts()) || entity.getEmployeeShifts() == null)
            return null;
        else
            return converter.from(new ArrayList<EmployeeShift>(entity.getEmployeeShifts()));
    }


}
