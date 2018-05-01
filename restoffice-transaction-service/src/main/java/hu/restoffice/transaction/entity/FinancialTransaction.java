/**
 *
 */
package hu.restoffice.transaction.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

import hu.restoffice.transaction.domain.DocumentType;
import hu.restoffice.transaction.domain.PaymentMethod;

/**
 * Superclass for expense and income persistence entities
 *
 * @author kalmankostenszky
 *
 */
@MappedSuperclass
public abstract class FinancialTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSACTION_ID_GENERATOR")
    private Long id;

    @Column(length = 100)
    @NotBlank
    private String docId;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    @NotNull
    private DocumentType docType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Partner party;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    @NotNull
    private PaymentMethod payMethod;

    @Column(nullable = false)
    @Positive
    private BigDecimal grossTotal;

    @Column(length = 200)
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    @FutureOrPresent
    private Date registered;

    @Temporal(TemporalType.DATE)
    @FutureOrPresent
    private Date expiry;

    @Temporal(TemporalType.DATE)
    @PastOrPresent
    private Date payed;

    @Embedded
    private AccountingPeriod accPeriod;

    private Date lastModifiedAt;

    // @ManyToOne(fetch = FetchType.LAZY)
    // private User lastModifiedBy;

    // constructors
    public FinancialTransaction() {

    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    // getters and setters
    /**
     * @return the docId
     */
    public String getDocId() {
        return docId;
    }

    /**
     * @param docId
     *            the docId to set
     */
    public void setDocId(final String docId) {
        this.docId = docId;
    }

    /**
     * @return the docType
     */
    public DocumentType getDocType() {
        return docType;
    }

    /**
     * @param docType
     *            the docType to set
     */
    public void setDocType(final DocumentType docType) {
        this.docType = docType;
    }

    /**
     * @return the party
     */
    public Partner getParty() {
        return party;
    }

    /**
     * @param party
     *            the party to set
     */
    public void setParty(final Partner party) {
        this.party = party;
    }

    /**
     * @return the payMethod
     */
    public PaymentMethod getPayMethod() {
        return payMethod;
    }

    /**
     * @param payMethod
     *            the payMethod to set
     */
    public void setPayMethod(final PaymentMethod payMethod) {
        this.payMethod = payMethod;
    }

    /**
     * @return the grossTotal
     */
    public BigDecimal getGrossTotal() {
        return grossTotal;
    }

    /**
     * @param grossTotal
     *            the grossTotal to set
     */
    public void setGrossTotal(final BigDecimal grossTotal) {
        this.grossTotal = grossTotal;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * @return the registered
     */
    public Date getRegistered() {
        return registered;
    }

    /**
     * @param registered
     *            the registered to set
     */
    public void setRegistered(final Date registered) {
        this.registered = registered;
    }

    /**
     * @return the expiry
     */
    public Date getExpiry() {
        return expiry;
    }

    /**
     * @param expiry
     *            the expiry to set
     */
    public void setExpiry(final Date expiry) {
        this.expiry = expiry;
    }

    /**
     * @return the payed
     */
    public Date getPayed() {
        return payed;
    }

    /**
     * @param payed
     *            the payed to set
     */
    public void setPayed(final Date payed) {
        this.payed = payed;
    }

    /**
     * @return the accPeriod
     */
    public AccountingPeriod getAccPeriod() {
        return accPeriod;
    }

    /**
     * @param accPeriod
     *            the accPeriod to set
     */
    public void setAccPeriod(final AccountingPeriod accPeriod) {
        this.accPeriod = accPeriod;
    }

    /**
     * @return the lastModifiedAt
     */
    public Date getLastModifiedAt() {
        return lastModifiedAt;
    }

    /**
     * @param lastModifiedAt
     *            the lastModifiedAt to set
     */
    public void setLastModifiedAt(final Date lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    // /**
    // * @return the lastModifiedBy
    // */
    // public User getLastModifiedBy() {
    // return lastModifiedBy;
    // }
    //
    // /**
    // * @param lastModifiedBy
    // * the lastModifiedBy to set
    // */
    // public void setLastModifiedBy(final User lastModifiedBy) {
    // this.lastModifiedBy = lastModifiedBy;
    // }

}
