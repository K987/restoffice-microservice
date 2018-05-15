package hu.restoffice.dailyclose.client;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String employeeName;
    @JsonProperty
    LocalDate startDate;
    @JsonProperty
    LocalTime startTime;
    @JsonIgnore
    Long shiftId;
    @JsonProperty
    private JobPosition position;
    @JsonProperty
    private Long employeeId;
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
     * @param employeeName
     * @param startDate
     * @param startTime
     * @param shiftId
     * @param position
     * @param employeeId
     * @param actualStart
     * @param actualEnd
     * @param hoursWorked
     * @param actualPosition
     */
    public EmployeeShiftStub(final Long id, final String employeeName, final LocalDate startDate,
            final LocalTime startTime, final Long shiftId, final JobPosition position, final Long employeeId,
            final LocalDateTime actualStart, final LocalDateTime actualEnd, final Duration hoursWorked,
            final JobPosition actualPosition) {
        super();
        this.id = id;
        this.employeeName = employeeName;
        this.startDate = startDate;
        this.startTime = startTime;
        this.shiftId = shiftId;
        this.position = position;
        this.employeeId = employeeId;
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
     * @return the employeeName
     */
    public String getEmployeeName() {
        return employeeName;
    }


    /**
     * @return the startDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }


    /**
     * @return the startTime
     */
    public LocalTime getStartTime() {
        return startTime;
    }


    /**
     * @return the shiftId
     */
    public Long getShiftId() {
        return shiftId;
    }


    /**
     * @return the position
     */
    public JobPosition getPosition() {
        return position;
    }


    /**
     * @return the employeeId
     */
    public Long getEmployeeId() {
        return employeeId;
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
        return "EmployeeShiftStub [id=" + id + ", employeeName=" + employeeName + ", startDate=" + startDate
                + ", startTime=" + startTime + ", shiftId=" + shiftId + ", position=" + position + ", employeeId="
                + employeeId + ", actualStart=" + actualStart + ", actualEnd=" + actualEnd + ", hoursWorked="
                + hoursWorked + ", actualPosition=" + actualPosition + "]";
    }
}
