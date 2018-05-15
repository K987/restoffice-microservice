package hu.restoffice.employee.converter;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
        LocalTime startTime = null;
        Double shfiftLength = null;
        Long shiftId = null;
        if (Hibernate.isInitialized(entity.getShift()) && entity.getShift() != null) {
            startDate = entity.getShift().getStartDate();
            startTime = entity.getShift().getStartTime();
            shfiftLength = entity.getShift().getDuration();
            shiftId = entity.getShift().getId();
        }
        LocalDateTime actualStart = Optional.ofNullable(entity.getActualStart()).map(s -> s.toLocalDateTime()).orElse(null);
        LocalDateTime actualEnd = Optional.ofNullable(entity.getActualEnd()).map(s -> s.toLocalDateTime()).orElse(null);

        return new EmployeeShiftStub(entity.getId(), employeeName, startDate, startTime, shiftId, position, employeeId,
                actualStart, actualEnd, Duration.ofSeconds(0), entity.getActualPosition());
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
