package hu.restoffice.employee.converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.restoffice.employee.domain.EmployeeShiftStub;
import hu.restoffice.employee.domain.EmployeeStub;
import hu.restoffice.employee.domain.ShiftStub;
import hu.restoffice.employee.entity.EmployeeShift;

/**
 *
 */
@Component
public class EmployeeShiftConverterServiceImpl implements EmployeeShiftConverterService {

    @Autowired
    private EmployeeConverterService employeeConverter;
    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.commons.service.DefaultConverterService#from(java.lang.Object)
     */
    @Override
    public EmployeeShiftStub from(final EmployeeShift entity) {
        return new EmployeeShiftStub(entity.getId(), getEmployeeStub(entity), getShiftStub(entity),
                initLocalDateTime(entity.getActualStart()), initLocalDateTime(entity.getActualEnd()),
                entity.getHoursWorked(), entity.getActualPosition());
    }


    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.commons.service.DefaultConverterService#to(java.lang.Object)
     */
    @Override
    public EmployeeShift to(final EmployeeShiftStub stub) {
        EmployeeShift e = new EmployeeShift();
        e.setActualEnd(Optional.ofNullable(stub.getActualEnd()).map(dt -> Timestamp.valueOf(dt)).orElse(null));
        e.setActualPosition(stub.getActualPosition());
        e.setActualStart(Optional.ofNullable(stub.getActualStart()).map(dt -> Timestamp.valueOf(dt)).orElse(null));
        return e;
    }

    /**
     * @param entity
     * @return
     */
    private ShiftStub getShiftStub(final EmployeeShift entity) {
        return null;
    }

    /**
     * @param entity
     * @return
     */
    private EmployeeStub getEmployeeStub(final EmployeeShift entity) {
        if (!Hibernate.isInitialized(entity.getEmployee()) || entity.getEmployee() == null)
            return null;
        else
            return employeeConverter.from(entity.getEmployee());
    }

    private LocalDateTime initLocalDateTime(final Timestamp date) {
        return Optional.ofNullable(date).map(Timestamp::toLocalDateTime).orElse(null);
    }

}
