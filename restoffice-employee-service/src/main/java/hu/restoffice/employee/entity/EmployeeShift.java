package hu.restoffice.employee.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import hu.restoffice.employee.domain.JobPosition;

/**
 *
 */
@Entity
@Table(name = "employee_shift")
public class EmployeeShift implements Serializable {

    private static final long serialVersionUID = 373756085894820717L;

    @SequenceGenerator(name = "employee_shift_employee_shift_id_generator", sequenceName = "employee_shift_employee_shift_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_shift_employee_shift_id_generator")
    @Column(name = "employee_shift_id", updatable = false)
    private Long id;

    // bi-directional many-to-one association to Shift
    @ManyToOne
    @JoinColumn(name = "employee_shift_employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    // bi-directional many-to-one association to Shift
    @ManyToOne
    @JoinColumn(name = "employee_shift_shift_id", referencedColumnName = "shift_id")
    private Shift shift;

    @Column(name = "employee_shift_actual_start")
    private Timestamp actualStart;

    @Column(name = "employee_shift_actual_end")
    private Timestamp actualEnd;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "employee_shift_actual_position")
    private JobPosition actualPosition;

    public EmployeeShift(){

    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    public Timestamp getActualEnd() {
        return actualEnd;
    }

    public void setActualEnd(final Timestamp employeeShiftActualEnd) {
        actualEnd = employeeShiftActualEnd;
    }

    public JobPosition getActualPosition() {
        return actualPosition;
    }

    public void setActualPosition(final JobPosition employeeShiftActualPosition) {
        actualPosition = employeeShiftActualPosition;
    }

    public Timestamp getActualStart() {
        return actualStart;
    }

    public void setActualStart(final Timestamp employeeShiftActualStart) {
        actualStart = employeeShiftActualStart;
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(final Employee employee) {
        this.employee = employee;
        employee.addEmployeeShift(this);
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(final Shift shift) {
        this.shift = shift;
        shift.addEmployeeShift(this);
    }

}