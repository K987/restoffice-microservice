package hu.restoffice.transaction.entity;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import hu.restoffice.commons.entity.Identity;

/**
 *
 */
@Entity
@Table(name = "incomes")
@AttributeOverrides(value = {
        @AttributeOverride(name = "docId", column = @Column(name = "income_doc_id")),
        @AttributeOverride(name = "docType", column = @Column(name = "income_doc_type")),
        @AttributeOverride(name = "payMethod", column = @Column(name = "income_payment_method")),
        @AttributeOverride(name = "grossTotal", column = @Column(name = "income_gross_amount")),
        @AttributeOverride(name = "description", column = @Column(name = "income_description")),
        @AttributeOverride(name = "registered", column = @Column(name = "income_issue_date")),
        @AttributeOverride(name = "expiry", column = @Column(name = "income_expiry_date")),
        @AttributeOverride(name = "payed", column = @Column(name = "income_payed_date")),
        @AttributeOverride(name = "accPeriod.startDate", column = @Column(name = "income_acc_per_start")),
        @AttributeOverride(name = "accPeriod.endDate", column = @Column(name = "income_acc_per_end"))
        // @AttributeOverride(name = "lastModifiedAt", column = @Column(name =
        // "income_last_modified_dt"))
})
@AssociationOverrides(value = {
        @AssociationOverride(name = "party", joinColumns = @JoinColumn(name = "income_liable", referencedColumnName = "partner_id"))
        // @AssociationOverride(name = "lastModifiedBy", joinColumns = @JoinColumn(name
        // = "income_last_modified_by", referencedColumnName = "user_id"))
})
public class Income extends FinancialTransaction implements Serializable, Identity {

    private static final long serialVersionUID = 7025564263254038236L;

    @Id
    @SequenceGenerator(name = "INCOMES_INCOME_ID_GENERATOR", sequenceName = "INCOMES_INCOME_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INCOMES_INCOME_ID_GENERATOR")
    @Column(name = "income_id")
    private Long id;

    // bi-directional many-to-one association to IncType
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "income_type", nullable = false)
    private IncomeType incType;

    // constructors
    public Income() {
    }

    /**
     * @return the id
     */
    @Override
    public Long getId() {
        return id;
    }

    public IncomeType getIncType() {
        return incType;
    }

    public void setIncType(final IncomeType incType) {
        this.incType = incType;
    }

}
