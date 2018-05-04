package hu.restoffice.transaction.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public abstract class FinancialTransactionStub {

    @JsonProperty
    private Long id;
    @NotBlank
    @JsonProperty
    private String docId;
    @NotNull
    @JsonProperty
    private DocumentType docType;
    @NotNull
    @JsonProperty
    private String partnerName;
    @JsonIgnore
    private Long partnerId;
    @JsonProperty
    private PaymentMethod payMethod;
    @Positive
    @JsonProperty
    private BigDecimal grossTotal;
    @JsonProperty
    private String description;
    @NotNull
    @JsonProperty
    private LocalDate registered;
    @NotNull
    @JsonProperty
    private LocalDate expiry;
    @JsonProperty
    private LocalDate payed;
    @JsonProperty
    private LocalDate accPeriodStart;
    @JsonProperty
    private LocalDate accPeriodEnd;

    public FinancialTransactionStub() {

    }

    /**
     * @param id
     * @param docId
     * @param docType
     * @param partnerName
     * @param partnerId
     * @param payMethod
     * @param grossTotal
     * @param description
     * @param registered
     * @param expiry
     * @param payed
     * @param accPeriodStart
     * @param accPeriodEnd
     */
    public FinancialTransactionStub(final Long id, final String docId, final DocumentType docType,
            final String partnerName, final Long partnerId, final PaymentMethod payMethod,
            final BigDecimal grossTotal, final String description, final LocalDate registered, final LocalDate expiry,
            final LocalDate payed, final LocalDate accPeriodStart, final LocalDate accPeriodEnd) {
        super();
        this.id = id;
        this.docId = docId;
        this.docType = docType;
        this.partnerName = partnerName;
        this.partnerId = partnerId;
        this.payMethod = payMethod;
        this.grossTotal = grossTotal;
        this.description = description;
        this.registered = registered;
        this.expiry = expiry;
        this.payed = payed;
        this.accPeriodStart = accPeriodStart;
        this.accPeriodEnd = accPeriodEnd;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the docId
     */
    public String getDocId() {
        return docId;
    }

    /**
     * @return the docType
     */
    public DocumentType getDocType() {
        return docType;
    }

    /**
     * @return the partnerName
     */
    public String getPartnerName() {
        return partnerName;
    }

    /**
     * @return the partnerId
     */
    public Long getPartnerId() {
        return partnerId;
    }

    /**
     * @return the payMethod
     */
    public PaymentMethod getPayMethod() {
        return payMethod;
    }

    /**
     * @return the grossTotal
     */
    public BigDecimal getGrossTotal() {
        return grossTotal;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the registered
     */
    public LocalDate getRegistered() {
        return registered;
    }

    /**
     * @return the expiry
     */
    public LocalDate getExpiry() {
        return expiry;
    }

    /**
     * @return the payed
     */
    public LocalDate getPayed() {
        return payed;
    }

    /**
     * @return the accPeriodStart
     */
    public LocalDate getAccPeriodStart() {
        return accPeriodStart;
    }

    /**
     * @return the accPeriodEnd
     */
    public LocalDate getAccPeriodEnd() {
        return accPeriodEnd;
    }


    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "FinancialTransactionStub [id=" + id + ", docId=" + docId + ", docType=" + docType + ", partnerName="
                + partnerName + ", partnerId=" + partnerId + ", payMethod=" + payMethod + ", grossTotal=" + grossTotal
                + ", description=" + description + ", registered=" + registered + ", expiry=" + expiry + ", payed="
                + payed + ", accPeriodStart=" + accPeriodStart + ", accPeriodEnd=" + accPeriodEnd + "]";
    }


}
