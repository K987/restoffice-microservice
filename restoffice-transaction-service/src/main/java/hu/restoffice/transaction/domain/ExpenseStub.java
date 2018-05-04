package hu.restoffice.transaction.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
public class ExpenseStub extends FinancialTransactionStub {

    @NotNull
    @JsonProperty
    private String expenseType;
    @JsonIgnore
    private Long expenseTypeId;

    @NotNull
    @JsonProperty
    private String costCenter;
    @JsonIgnore
    private Long costCenterId;

    public ExpenseStub() {

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
     * @param expenseType
     * @param expenseTypeId
     */
    public ExpenseStub(final Long id, final String docId, final DocumentType docType, final String partnerName,
            final Long partnerId, final PaymentMethod payMethod, final BigDecimal grossTotal,
            final String description, final LocalDate registered, final LocalDate expiry, final LocalDate payed,
            final LocalDate accPeriodStart, final LocalDate accPeriodEnd, final String expenseType,
            final Long expenseTypeId, final String costCenterName, final Long costCenterId) {
        super(id, docId, docType, partnerName, partnerId, payMethod, grossTotal, description, registered, expiry, payed,
                accPeriodStart, accPeriodEnd);
        this.expenseType = expenseType;
        this.expenseTypeId = expenseTypeId;
        costCenter = costCenterName;
        this.costCenterId = costCenterId;
    }

    /**
     * @return the expenseType
     */
    public String getExpenseType() {
        return expenseType;
    }

    /**
     * @return the expenseTypeId
     */
    public Long getExpenseTypeId() {
        return expenseTypeId;
    }

    /**
     * @return the costCenter
     */
    public String getCostCenter() {
        return costCenter;
    }

    /**
     * @return the costCenterId
     */
    public Long getCostCenterId() {
        return costCenterId;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ExpenseStub [expenseType=" + expenseType + ", expenseTypeId=" + expenseTypeId + ", costCenter="
                + costCenter + ", costCenterId=" + costCenterId + " SUPER: " + super.toString() + "]";
    }



}
