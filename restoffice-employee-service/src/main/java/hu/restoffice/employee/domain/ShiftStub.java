package hu.restoffice.employee.domain;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
@JsonInclude(value = Include.NON_EMPTY)
public class ShiftStub {

    // TODO: validátorok
    // TODO: kapcsolódó entitás fetch strtatégiáját megnézni

    @JsonProperty
    private Long id;
    @JsonProperty
    private Double duration;
    @JsonProperty
    private LocalDateTime startDateTime;
    @JsonProperty
    private List<EmployeeShiftStub> employeeShifts;

    public ShiftStub() {

    }

    /**
     * @param id
     * @param duration
     * @param startDateTime
     * @param employeeShifts
     */
    public ShiftStub(final Long id, final Double duration, final LocalDateTime startDateTime,
            final List<EmployeeShiftStub> employeeShifts) {
        super();
        this.id = id;
        this.duration = duration;
        this.startDateTime = startDateTime;
        this.employeeShifts = employeeShifts;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the duration
     */
    public Double getDuration() {
        return duration;
    }

    /**
     * @return the startDateTime
     */
    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    /**
     * @return the employeeShifts
     */
    public List<EmployeeShiftStub> getEmployeeShifts() {
        return employeeShifts;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ShiftStub [id=" + id + ", duration=" + duration + ", startDateTime=" + startDateTime
                + ", employeeShifts=" + employeeShifts + "]";
    }

}
