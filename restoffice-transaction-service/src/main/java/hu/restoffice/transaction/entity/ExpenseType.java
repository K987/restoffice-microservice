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

/**
 *
 */
@Entity
@Table(name = "expense_types")
public class ExpenseType implements Serializable {

    private static final long serialVersionUID = -7693502259133533204L;

    @Id
    @SequenceGenerator(name = "EXP_TYPES_EXPTYPEID_GENERATOR", sequenceName = "EXP_TYPES_EXP_TYPE_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXP_TYPES_EXPTYPEID_GENERATOR")
    @Column(name = "exp_type_id")
    private Long id;

    @Column(name = "exp_type_name", nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "exp_type_prod_related", nullable = false)
    private Boolean prodRelated;

    // bi-directional many-to-one association to Expense
    @OneToMany(mappedBy = "expType", fetch = FetchType.LAZY, targetEntity = Expense.class)
    private Set<Expense> expenses;

    public ExpenseType() {
    }

    /**
     * @param expense
     * @return
     */
    public Expense addExpense(final Expense expense) {
        getExpenses().add(expense);
        expense.setExpType(this);

        return expense;
    }

    /**
     * @param expense
     * @return
     */
    public Expense removeExpense(final Expense expense) {
        getExpenses().remove(expense);
        expense.setExpType(null);

        return expense;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Boolean isProdRelated() {
        return prodRelated;
    }

    public void setProdRelated(final Boolean prodRelated) {
        this.prodRelated = prodRelated;
    }

    public Set<Expense> getExpenses() {
        return expenses;
    }

}
