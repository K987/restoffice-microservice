package hu.restoffice.transaction.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 *
 */
public class ExpenseStub {

    private final Long id;
    @NotBlank
    private final String docId;
    @NotNull
    private final PartnerStub partner;
    @NotNull
    private final PaymentMethod paymentMethod;
    @NotNull
    private final ExpenseTypeStub expenseType;
    @NotNull
    private final LocalDate registered;
    private final LocalDate payed;
    @Positive
    private final BigDecimal grossTotal;
    @NotNull
    @FutureOrPresent
    private final LocalDate expiry;
    @NotNull
    private final DocumentType docType;
    private final String description;
    private final LocalDate accPeriodEnd;
    private final LocalDate accPeriodStart;

    /**
     * @param id
     * @param docId
     * @param partnerId
     * @param partner
     * @param paymentMethod
     * @param incomeTypeId
     * @param incomeType
     * @param registered
     * @param payed
     * @param grossTotal
     * @param expiry
     * @param docType
     * @param description
     * @param accPeriodEnd
     * @param accPeriodStart
     */
    public ExpenseStub(final Long id, final String docId, final PartnerStub partner, final PaymentMethod paymentMethod,
            final ExpenseTypeStub expenseType,
            final LocalDate registered, final LocalDate payed, final BigDecimal grossTotal, final LocalDate expiry,
            final DocumentType docType, final String description, final LocalDate accPeriodEnd,
            final LocalDate accPeriodStart) {
        super();
        this.id = id;
        this.docId = docId;
        this.partner = partner;
        this.paymentMethod = paymentMethod;
        this.expenseType = expenseType;
        this.registered = registered;
        this.payed = payed;
        this.grossTotal = grossTotal;
        this.expiry = payed;
        this.docType = docType;
        this.description = description;
        this.accPeriodEnd = accPeriodEnd;
        this.accPeriodStart = accPeriodStart;
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
     * @return the partner
     */
    public PartnerStub getPartner() {
        return partner;
    }

    /**
     * @return the paymentMethod
     */
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * @return the incomeType
     */
    public ExpenseTypeStub getExpenseType() {
        return expenseType;
    }

    /**
     * @return the registered
     */
    public LocalDate getRegistered() {
        return registered;
    }

    /**
     * @return the payed
     */
    public LocalDate getPayed() {
        return payed;
    }

    /**
     * @return the grossTotal
     */
    public BigDecimal getGrossTotal() {
        return grossTotal;
    }

    /**
     * @return the expiry
     */
    public LocalDate getExpiry() {
        return expiry;
    }

    /**
     * @return the docType
     */
    public DocumentType getDocType() {
        return docType;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the accPeriodEnd
     */
    public LocalDate getAccPeriodEnd() {
        return accPeriodEnd;
    }

    /**
     * @return the accPeriodStart
     */
    public LocalDate getAccPeriodStart() {
        return accPeriodStart;
    }

}
