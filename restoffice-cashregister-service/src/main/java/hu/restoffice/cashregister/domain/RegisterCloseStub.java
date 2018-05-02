package hu.restoffice.cashregister.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
public class RegisterCloseStub {

    @JsonProperty
    private Long id;
    @JsonProperty
    private Long closeNo;
    @JsonProperty
    private BigDecimal closingAmount;
    @JsonProperty
    private LocalDate closeDate;
    @JsonProperty
    private String registerRegistrationNo;

    public RegisterCloseStub() {
    }

    /**
     * @param id
     * @param closeNo
     * @param closingAmount
     * @param closeDate
     * @param register
     */
    public RegisterCloseStub(final Long id, final Long closeNo, final BigDecimal closingAmount,
            final LocalDate closeDate, final String registerRegistrationNo) {
        super();
        this.id = id;
        this.closeNo = closeNo;
        this.closingAmount = closingAmount;
        this.closeDate = closeDate;
        this.registerRegistrationNo = registerRegistrationNo;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the closeNo
     */
    public Long getCloseNo() {
        return closeNo;
    }

    /**
     * @return the closingAmount
     */
    public BigDecimal getClosingAmount() {
        return closingAmount;
    }

    /**
     * @return the closeDate
     */
    public LocalDate getCloseDate() {
        return closeDate;
    }
    
    /**
     * @return the registerRegistrationNo
     */
    public String getRegisterRegistrationNo() {
        return registerRegistrationNo;
    }
}
