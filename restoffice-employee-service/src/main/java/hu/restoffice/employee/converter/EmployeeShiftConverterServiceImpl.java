package hu.restoffice.employee.converter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.restoffice.employee.domain.EmployeeShiftStub;
import hu.restoffice.employee.domain.JobPosition;
import hu.restoffice.employee.entity.EmployeeShift;

/**
 *
 */
@Component
public class EmployeeShiftConverterServiceImpl implements EmployeeShiftConverterService {

    @Autowired
    ShiftConverterService shiftConverter;
    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.commons.service.DefaultConverterService#from(java.lang.Object)
     */

    @Override
    public EmployeeShiftStub from(final EmployeeShift entity) {

        String employeeName = null;
        JobPosition position = null;
        Long employeeId = null;
        if (Hibernate.isInitialized(entity.getEmployee()) && entity.getEmployee() != null) {
            employeeName = entity.getEmployee().getEmployeeName();
            position = entity.getEmployee().getDefaultPosition();
            employeeId = entity.getEmployee().getId();
        }

        LocalDate startDate = null;
        LocalDate startTime = null;
        Double shfiftLength = null;
        Long shiftId = null;
        if (Hibernate.isInitialized(entity.getShift()) && entity.getShift() != null) {
            startDate = entity.getShift().getStartDate();
            startTime = entity.getShift().getStartDate();
            shfiftLength = entity.getShift().getDuration();
            shiftId = entity.getShift().getId();
        }

        return null;
        // initLocalDateTime(entity.getActualStart()),
        // initLocalDateTime(entity.getActualEnd()),
        // entity.getHoursWorked(), entity.getActualPosition());
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



    private LocalDateTime initLocalDateTime(final Timestamp date) {
        return Optional.ofNullable(date).map(Timestamp::toLocalDateTime).orElse(null);
    }

}
