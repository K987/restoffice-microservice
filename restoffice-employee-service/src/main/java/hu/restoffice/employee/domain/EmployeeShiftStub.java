package hu.restoffice.employee.domain;

import java.time.Duration;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
@JsonInclude(value = Include.NON_EMPTY)
public class EmployeeShiftStub {

    // TODO: validációkat megcsinálni
    // TODO: megnézni a fetch típusaokat az entitásokban

    @JsonProperty
    private Long id;
    @JsonProperty
    private EmployeeStub employee;
    @JsonProperty
    private ShiftStub shift;
    @JsonProperty
    private LocalDateTime actualStart;
    @JsonProperty
    private LocalDateTime actualEnd;
    @JsonProperty
    private Duration hoursWorked;
    @JsonProperty
    private JobPosition actualPosition;

    public EmployeeShiftStub() {

    }

    /**
     * @param id
     * @param employee
     * @param shift
     * @param actualStart
     * @param actualEnd
     * @param hoursWorked
     * @param actualPosition
     */
    public EmployeeShiftStub(final Long id, final EmployeeStub employee, final ShiftStub shift,
            final LocalDateTime actualStart, final LocalDateTime actualEnd, final Duration hoursWorked,
            final JobPosition actualPosition) {
        super();
        this.id = id;
        this.employee = employee;
        this.shift = shift;
        this.actualStart = actualStart;
        this.actualEnd = actualEnd;
        this.hoursWorked = hoursWorked;
        this.actualPosition = actualPosition;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the employee
     */
    public EmployeeStub getEmployee() {
        return employee;
    }

    /**
     * @return the shift
     */
    public ShiftStub getShift() {
        return shift;
    }

    /**
     * @return the actualStart
     */
    public LocalDateTime getActualStart() {
        return actualStart;
    }

    /**
     * @return the actualEnd
     */
    public LocalDateTime getActualEnd() {
        return actualEnd;
    }

    /**
     * @return the hoursWorked
     */
    public Duration getHoursWorked() {
        return hoursWorked;
    }

    /**
     * @return the actualPosition
     */
    public JobPosition getActualPosition() {
        return actualPosition;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "EmployeeShiftStub [id=" + id + ", employee=" + employee + ", shift=" + shift + ", actualStart="
                + actualStart + ", actualEnd=" + actualEnd + ", hoursWorked=" + hoursWorked + ", actualPosition="
                + actualPosition + "]";
    }
}
