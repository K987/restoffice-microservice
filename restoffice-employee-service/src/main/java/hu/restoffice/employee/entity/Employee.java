package hu.restoffice.employee.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import hu.restoffice.employee.domain.JobPosition;

/**
 *
 */
@Entity
@Table(name = "employees")
public class Employee implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "EMPLOYEES_EMPLOYEEID_GENERATOR", sequenceName = "EMPLOYEES_EMPLOYEE_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEES_EMPLOYEEID_GENERATOR")
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "employee_active", nullable = false)
    private Boolean active;

    @Column(name = "employee_default_hourly_wage")
    private BigDecimal defaultHourlyWage;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "employee_default_position", nullable = false)
    private JobPosition defaultPosition;

    @Column(name = "employee_name", nullable = false, length = 100)
    private String name;

    // bi-directional many-to-one association to EmployeeShift
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, targetEntity = EmployeeShift.class, orphanRemoval = true, cascade = CascadeType.REMOVE)
    private Set<EmployeeShift> employeeShifts;

    public Employee() {
    }

    /**
     *
     * @param employeeShift
     * @return
     */
    public EmployeeShift addEmployeeShift(final EmployeeShift employeeShift) {
        getEmployeeShifts().add(employeeShift);
        employeeShift.setEmployee(this);

        return employeeShift;
    }

    public EmployeeShift removeEmployeeShift(final EmployeeShift employeeShift) {
        getEmployeeShifts().remove(employeeShift);
        employeeShift.setEmployee(null);

        return employeeShift;
    }

    public Long getId() {
        return id;
    }

    public Boolean IsActive() {
        return active;
    }

    public void setActive(final Boolean employeeActive) {
        active = employeeActive;
    }

    public BigDecimal getDefaultHourlyWage() {
        return defaultHourlyWage;
    }

    public void setDefaultHourlyWage(final BigDecimal employeeDefaultHourlyWage) {
        defaultHourlyWage = employeeDefaultHourlyWage;
    }

    public JobPosition getDefaultPosition() {
        return defaultPosition;
    }

    public void setDefaultPosition(final JobPosition employeeDefaultPosition) {
        defaultPosition = employeeDefaultPosition;
    }

    public String getEmployeeName() {
        return name;
    }

    public void setEmployeeName(final String employeeName) {
        name = employeeName;
    }

    public Set<EmployeeShift> getEmployeeShifts() {
        return employeeShifts;
    }

    public void setEmployeeShifts(final Set<EmployeeShift> employeeShifts) {
        this.employeeShifts = employeeShifts;
    }
}
