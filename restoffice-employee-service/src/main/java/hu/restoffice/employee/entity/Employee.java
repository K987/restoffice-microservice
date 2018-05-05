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

import hu.restoffice.commons.entity.Identity;
import hu.restoffice.employee.domain.JobPosition;

/**
 *
 */
@Entity
@Table(name = "employees")
public class Employee implements Serializable, Identity {


    private static final long serialVersionUID = 5206798093009220029L;

    @Id
    @SequenceGenerator(name = "EMPLOYEES_EMPLOYEEID_GENERATOR", sequenceName = "EMPLOYEES_EMPLOYEE_ID_SEQ", allocationSize = 1)
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
        if (!employeeShifts.contains(employeeShift)) {
            employeeShift.setEmployee(this);
            employeeShifts.add(employeeShift);
        }
        return employeeShift;
    }

    public EmployeeShift removeEmployeeShift(final EmployeeShift employeeShift) {
        if (employeeShifts.contains(employeeShift)) {
            employeeShifts.remove(employeeShift);
            employeeShift.setEmployee(null);
        }
        return employeeShift;
    }

    @Override
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

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Employee [id=" + id + ", active=" + active + ", defaultHourlyWage=" + defaultHourlyWage
                + ", defaultPosition=" + defaultPosition + ", name=" + name + ", employeeShifts="
                + (employeeShifts == null) + "]";
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Employee))
            return false;
        Employee other = (Employee) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
