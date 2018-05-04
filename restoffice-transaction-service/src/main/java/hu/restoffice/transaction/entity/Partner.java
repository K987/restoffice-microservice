package hu.restoffice.transaction.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import hu.restoffice.commons.entity.Identity;

/**
 *
 */
@Entity
@Table(name = "partners")
public class Partner implements Serializable, Identity {

    private static final long serialVersionUID = -8378660922522209425L;

    @Id
    @SequenceGenerator(name = "PARTNERS_PARTNERID_GENERATOR", sequenceName = "PARTNERS_PARTNER_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PARTNERS_PARTNERID_GENERATOR")
    @Column(name = "partner_id", updatable = false, unique = true, nullable = false)
    private Long id;

    @Column(name = "partner_technical", nullable = false)
    private Boolean technical;

    @Column(name = "partner_account", length = 100)
    private String account;

    @Column(name = "partner_name", nullable = false, length = 100)
    private String name;

    @Embedded
    private PartnerContact contact;

    @OneToMany(mappedBy = "party", fetch = FetchType.LAZY, targetEntity = Expense.class)
    private Set<Expense> expenses;

    @OneToMany(mappedBy = "party", fetch = FetchType.LAZY, targetEntity = Income.class)
    private Set<Income> incomes;

    public Partner() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public Boolean isTechnical() {
        return technical;
    }

    public void setTechnical(final Boolean parnterTechnical) {
        technical = parnterTechnical;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(final String partnerAccount) {
        account = partnerAccount;
    }

    public PartnerContact getContact() {
        return contact;
    }

    public void setContact(final PartnerContact contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Set<Expense> getExpenses() {
        return expenses;
    }

    /**
     * bidirectional
     *
     * @param expense
     * @return
     */
    public Expense addExpense(final Expense expense) {
        getExpenses().add(expense);
        expense.setParty(this);

        return expense;
    }

    /**
     * bidirectional
     *
     * @param expense
     * @return
     */
    public Expense removeExpense(final Expense expense) {
        getExpenses().remove(expense);
        expense.setParty(null);

        return expense;
    }

    public Set<Income> getIncomes() {
        return incomes;
    }

    /**
     * bidirectional
     *
     * @param income
     * @return
     */
    public Income addIncome(final Income income) {
        getIncomes().add(income);
        income.setParty(this);

        return income;
    }

    /**
     * bidirectional
     *
     * @param income
     * @return
     */
    public Income removeIncome(final Income income) {
        getIncomes().remove(income);
        income.setParty(null);

        return income;
    }
}
