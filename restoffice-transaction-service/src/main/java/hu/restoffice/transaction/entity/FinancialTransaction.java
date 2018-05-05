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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

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

    @Column(length = 100)
    private String docId;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private DocumentType docType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Partner party;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private PaymentMethod payMethod;

    @Column(nullable = false)
    private BigDecimal grossTotal;

    @Column(length = 200)
    private String description;

    @Column(nullable = false)
    private Date registered;

    private Date expiry;

    private Date payed;

    @Embedded
    private AccountingPeriod accPeriod;

    // private Date lastModifiedAt;

    // @ManyToOne(fetch = FetchType.LAZY)
    // private User lastModifiedBy;

    // constructors
    public FinancialTransaction() {

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

    // /**
    // * @return the lastModifiedAt
    // */
    // public Date getLastModifiedAt() {
    // return lastModifiedAt;
    // }
    //
    // /**
    // * @param lastModifiedAt
    // * the lastModifiedAt to set
    // */
    // public void setLastModifiedAt(final Date lastModifiedAt) {
    // this.lastModifiedAt = lastModifiedAt;
    // }

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
