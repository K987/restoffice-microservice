package hu.restoffice.employee.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import hu.restoffice.commons.entity.Identity;

/**
 *
 */
@Entity
@Table(name = "shifts")
public class Shift implements Serializable, Identity {

    private static final long serialVersionUID = 6872015514882085018L;

    @Id
    @SequenceGenerator(name = "SHIFTS_SHIFTID_GENERATOR", sequenceName = "SHIFTS_SHIFT_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SHIFTS_SHIFTID_GENERATOR")
    @Column(name = "shift_id")
    private Long id;

    @Column(name = "shift_duration", nullable = false)
    private Double duration;

    @Column(name = "shift_start_dt", nullable = false)
    private Timestamp startDateTime;

    @Transient
    private LocalDate startDate;

    @Transient
    private LocalTime startTime;

    // bi-directional many-to-one association to EmployeeShift
    @OneToMany(mappedBy = "shift", fetch = FetchType.LAZY, targetEntity = EmployeeShift.class)
    private Set<EmployeeShift> employeeShifts;

    public Shift() {
    }

    @PostLoad
    protected void setDateAndTime() {
        startDate = Optional.ofNullable(startDateTime).map(s -> s.toLocalDateTime().toLocalDate()).orElse(null);
        startTime = Optional.ofNullable(startDateTime).map(s -> s.toLocalDateTime().toLocalTime()).orElse(null);
    }

    public EmployeeShift addEmployeeShift(final EmployeeShift employeeShift) {
        getEmployeeShifts().add(employeeShift);
        employeeShift.setShift(this);

        return employeeShift;
    }

    public EmployeeShift removeEmployeeShift(final EmployeeShift employeeShift) {
        getEmployeeShifts().remove(employeeShift);
        employeeShift.setShift(null);

        return employeeShift;
    }

    @Override
    public Long getId() {
        return id;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(final Double shiftDuration) {
        duration = shiftDuration;
    }

    /**
     * @return the startDateTime
     */
    public Timestamp getStartDateTime() {
        return startDateTime;
    }

    /**
     * @param startDateTime
     *            the startDateTime to set
     */
    public void setStartDateTime(final Timestamp startDateTime) {
        this.startDateTime = startDateTime;
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

    public Set<EmployeeShift> getEmployeeShifts() {
        return employeeShifts;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Shift [id=" + id + ", duration=" + duration + ", startDateTime=" + startDateTime + ", startDate="
                + startDate + ", startTime=" + startTime + ", employeeShifts exists=" + (employeeShifts == null) + "]";
    }

}