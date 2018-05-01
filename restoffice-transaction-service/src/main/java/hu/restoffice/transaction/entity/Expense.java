package hu.restoffice.transaction.entity;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name = "expenses")
@SequenceGenerator(name = "TRANSACTION_ID_GENERATOR", sequenceName = "EXPENSES_EXPENSE_ID_SEQ")
@AttributeOverrides(value = { @AttributeOverride(name = "id", column = @Column(name = "expense_id")),
        @AttributeOverride(name = "docId", column = @Column(name = "expense_doc_id")),
        @AttributeOverride(name = "docType", column = @Column(name = "expense_doc_type")),
        @AttributeOverride(name = "payMethod", column = @Column(name = "expense_payment_method")),
        @AttributeOverride(name = "grossTotal", column = @Column(name = "expense_gross_amount")),
        @AttributeOverride(name = "description", column = @Column(name = "expense_description")),
        @AttributeOverride(name = "registered", column = @Column(name = "expense_recieved_date")),
        @AttributeOverride(name = "expiry", column = @Column(name = "expense_expiry_date")),
        @AttributeOverride(name = "payed", column = @Column(name = "expense_payed_date")),
        @AttributeOverride(name = "accPeriod.startDate", column = @Column(name = "expense_acc_per_start")),
        @AttributeOverride(name = "accPeriod.endDate", column = @Column(name = "expense_acc_per_end")),
        @AttributeOverride(name = "lastModifiedAt", column = @Column(name = "expense_last_modified_dt")) })
@AssociationOverrides(value = {
        @AssociationOverride(name = "party", joinColumns = @JoinColumn(name = "expense_issuer", referencedColumnName = "partner_id")),
        // @AssociationOverride(name = "lastModifiedBy", joinColumns = @JoinColumn(name
        // = "expense_last_modified_by", referencedColumnName = "user_id"))
})
public class Expense extends FinancialTransaction implements Serializable {


    private static final long serialVersionUID = 1451758378820116069L;

    // bi-directional many-to-one association to CostCenter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "expense_costcenter", nullable = false, referencedColumnName = "cost_center_id")
    private CostCenter costCenter;

    // bi-directional many-to-one association to ExpType
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "expense_type", nullable = false, referencedColumnName = "exp_type_id")
    private ExpenseType expType;

    public Expense() {
    }

    /**
     * @return
     */
    public CostCenter getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(final CostCenter costCenter) {
        this.costCenter = costCenter;
    }

    public ExpenseType getExpType() {
        return expType;
    }

    public void setExpType(final ExpenseType expType) {
        this.expType = expType;
    }

}