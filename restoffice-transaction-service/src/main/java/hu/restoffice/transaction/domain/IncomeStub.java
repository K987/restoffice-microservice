package hu.restoffice.transaction.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
public class IncomeStub extends FinancialTransactionStub {

    @NotNull
    @JsonProperty
    private String incomeType;

    @JsonIgnore
    private Long incomeTypeId;

    public IncomeStub() {
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
     * @param incomeType
     * @param incomeTypeId
     */
    public IncomeStub(final Long id, final String docId, final DocumentType docType, final String partnerName,
            final Long partnerId, final PaymentMethod payMethod, final BigDecimal grossTotal, final String description,
            final LocalDate registered, final LocalDate expiry, final LocalDate payed, final LocalDate accPeriodStart,
            final LocalDate accPeriodEnd, @NotNull final String incomeType, final Long incomeTypeId) {
        super(id, docId, docType, partnerName, partnerId, payMethod, grossTotal, description, registered, expiry, payed,
                accPeriodStart, accPeriodEnd);
        this.incomeType = incomeType;
        this.incomeTypeId = incomeTypeId;
    }


    /**
     * @return the incomeType
     */
    public String getIncomeType() {
        return incomeType;
    }

    /**
     * @return the incomeTypeId
     */
    public Long getIncomeTypeId() {
        return incomeTypeId;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "IncomeStub [incomeType=" + incomeType + ", incomeTypeId=" + incomeTypeId + "SUPER: " + super.toString()
        + "]";
    };


}
