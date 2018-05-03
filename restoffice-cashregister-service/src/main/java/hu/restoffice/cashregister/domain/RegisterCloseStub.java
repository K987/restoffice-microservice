package hu.restoffice.cashregister.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
@JsonInclude(Include.NON_EMPTY)
public class RegisterCloseStub extends ResourceSupport {

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
    @JsonIgnore
    private Long registerId;

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
            final LocalDate closeDate, final String registerRegistrationNo, final Long registerId) {
        super();
        this.id = id;
        this.closeNo = closeNo;
        this.closingAmount = closingAmount;
        this.closeDate = closeDate;
        this.registerRegistrationNo = registerRegistrationNo;
        this.registerId = registerId;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.hateoas.ResourceSupport#getId()
     */
    @Override
    public Link getId() {
        // TODO Auto-generated method stub
        return super.getId();
    }
    /**
     * @return the id
     */
    @JsonIgnore
    public Long getCloseId() {
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

    public Long getRegisterId() {
        return registerId;
    }

}
