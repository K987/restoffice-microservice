package hu.restoffice.dailyclose.domain;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
@JsonInclude(Include.NON_EMPTY)
public class ShiftDailyCloseStub {

    @JsonProperty
    private Long id;

    @JsonProperty
    private Long employeeId;

    @JsonProperty
    private String employeeName;

    @JsonProperty
    private BigDecimal posTotal;

    @JsonProperty
    private BigDecimal cardTotal;

    @JsonProperty
    private BigDecimal cashTotal;

    @JsonProperty
    private Long dailyCloseId;

    public ShiftDailyCloseStub() {

    }

    /**
     * @param id
     * @param employeeId
     * @param employeeName
     * @param posTotal
     * @param cardTotal
     * @param cashTotal
     */
    public ShiftDailyCloseStub(final Long id, final Long employeeId, final String employeeName,
            final BigDecimal posTotal, final BigDecimal cardTotal, final BigDecimal cashTotal,
            final Long dailyCloseId) {
        super();
        this.id = id;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.posTotal = posTotal;
        this.cardTotal = cardTotal;
        this.cashTotal = cashTotal;
        this.dailyCloseId = dailyCloseId;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the employeeId
     */
    public Long getEmployeeId() {
        return employeeId;
    }

    /**
     * @return the employeeName
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * @return the posTotal
     */
    public BigDecimal getPosTotal() {
        return posTotal;
    }

    /**
     * @return the cardTotal
     */
    public BigDecimal getCardTotal() {
        return cardTotal;
    }

    /**
     * @return the cashTotal
     */
    public BigDecimal getCashTotal() {
        return cashTotal;
    }

    /**
     * @return the dailyCloseId
     */
    public Long getDailyCloseId() {
        return dailyCloseId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ShiftDailyCloseStub [id=" + id + ", employeeId=" + employeeId + ", employeeName=" + employeeName
                + ", posTotal=" + posTotal + ", cardTotal=" + cardTotal + ", cashTotal=" + cashTotal + ", dailyCloseId="
                + dailyCloseId + "]";
    }

}