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
@Table(name = "income_types")
public class IncomeType implements Serializable {

    private static final long serialVersionUID = -3026418101327410970L;

    @Id
    @SequenceGenerator(name = "INC_TYPES_INCTYPEID_GENERATOR", sequenceName = "INC_TYPES_INC_TYPE_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INC_TYPES_INCTYPEID_GENERATOR")
    @Column(name = "income_type_id")
    private Long id;

    @Column(name = "income_type_name", unique = true, nullable = false, length = 100)
    private String name;

    @Column(name = "income_type_prod_related", nullable = false)
    private Boolean prodRelated;

    // bi-directional many-to-one association to Income
    @OneToMany(mappedBy = "", fetch = FetchType.LAZY, targetEntity = Income.class)
    private Set<Income> incomes;

    public IncomeType() {
    }

    public Income addIncome(final Income income) {
        getIncomes().add(income);
        income.setIncType(this);

        return income;
    }

    public Income removeIncome(final Income income) {
        getIncomes().remove(income);
        income.setIncType(null);

        return income;
    }

    /**
     * @return
     */
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

    public Set<Income> getIncomes() {
        return incomes;
    }
}
