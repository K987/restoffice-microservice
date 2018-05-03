package hu.restoffice.employee.domain;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
@JsonInclude(value = Include.NON_EMPTY)
public class EmployeeStub {

    // TODO: validatorok felfűzése
    // TODO: fetch stattégia!!
    // TODO: ellenőrizni, hogy semmelyik stub sem finaél

    @JsonProperty
    private Long id;
    @JsonProperty
    private Boolean active;
    @JsonProperty
    private BigDecimal defaultHourlyWage;
    @JsonProperty
    private JobPosition defaultPosition;
    @JsonProperty
    private String name;
    @JsonProperty
    private List<EmployeeShiftStub> employeeShifts;

    public EmployeeStub() {

    }

    /**
     * @param id
     * @param active
     * @param defaultHourlyWage
     * @param defaultPosition
     * @param name
     * @param employeeShifts
     */
    public EmployeeStub(final Long id, final Boolean active, final BigDecimal defaultHourlyWage,
            final JobPosition defaultPosition, final String name, final List<EmployeeShiftStub> employeeShifts) {
        super();
        this.id = id;
        this.active = active;
        this.defaultHourlyWage = defaultHourlyWage;
        this.defaultPosition = defaultPosition;
        this.name = name;
        this.employeeShifts = employeeShifts;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * @return the defaultHourlyWage
     */
    public BigDecimal getDefaultHourlyWage() {
        return defaultHourlyWage;
    }

    /**
     * @return the defaultPosition
     */
    public JobPosition getDefaultPosition() {
        return defaultPosition;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
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
        return "EmployeeStub [id=" + id + ", active=" + active + ", defaultHourlyWage=" + defaultHourlyWage
                + ", defaultPosition=" + defaultPosition + ", name=" + name + ", employeeShifts=" + employeeShifts
                + "]";
    }

}
