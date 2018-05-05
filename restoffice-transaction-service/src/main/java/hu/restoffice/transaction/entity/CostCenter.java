package hu.restoffice.transaction.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import hu.restoffice.commons.entity.Identity;

@Entity
@Table(name = "cost_centers")
public class CostCenter implements Serializable, Identity {

    private static final long serialVersionUID = 7273878052560094915L;

    @Id
    @SequenceGenerator(name = "COST_CENTERS_COSTCENTERID_GENERATOR", sequenceName = "COST_CENTERS_COST_CENTER_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COST_CENTERS_COSTCENTERID_GENERATOR")
    @Column(name = "cost_center_id")
    private Long id;

    @Column(name = "cost_center_default", nullable = false)
    private Boolean defaultCostCenter;

    @Column(name = "cost_center_name", nullable = false, unique = true, length = 100)
    private String name;

    // bi-directional many-to-one association to Expense
    @OneToMany(mappedBy = "costCenter", fetch = FetchType.LAZY, targetEntity = Expense.class)
    private Set<Expense> expenses;

    /**
     *
     */
    public CostCenter() {
    }

    /**
     * set an expense to this cost center
     *
     * @param expense
     *            to be added
     * @return the added expense
     */
    public Expense addExpense(final Expense expense) {
        getExpenses().add(expense);
        expense.setCostCenter(this);

        return expense;
    }

    /**
     * Remove an expense from cost center
     *
     * @param expense
     * to be removed
     * @return removed expense
     */
    public Expense removeExpense(final Expense expense) {
        getExpenses().remove(expense);
        expense.setCostCenter(null);

        return expense;
    }

    @Override
    public Long getId() {
        return id;
    }

    public Boolean isDefault() {
        return defaultCostCenter;
    }

    public void setDefault(final Boolean costCenterDefault) {
        defaultCostCenter = costCenterDefault;
    }

    public String getName() {
        return name;
    }

    public void setName(final String costCenterName) {
        name = costCenterName;
    }

    public Set<Expense> getExpenses() {
        return expenses;
    }
}
