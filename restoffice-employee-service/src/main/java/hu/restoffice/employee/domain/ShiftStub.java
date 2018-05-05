package hu.restoffice.employee.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;

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
    @NotNull
    private Double duration;
    @JsonProperty
    @NotNull
    private LocalDate startDate;
    @JsonProperty
    @NotNull
    private LocalTime startTime;

    public ShiftStub() {

    }

    /**
     * @param id
     * @param duration
     * @param startDateTime
     * @param employeeShifts
     */
    public ShiftStub(final Long id, final Double duration, final LocalDate startDate, final LocalTime startTime) {
        super();
        this.id = id;
        this.duration = duration;
        this.startDate = startDate;
        this.startTime = startTime;
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

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ShiftStub [id=" + id + ", duration=" + duration + ", startDate=" + startDate + ", startTime="
                + startTime + "]";
    }
}
