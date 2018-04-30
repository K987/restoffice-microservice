package hu.restoffice.transaction.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name = "partners")
public class Partner implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Partner.findAll";
    public static final String FIND_BY_NAME = "Partner.findByName";
    public static final String READ_BY_ID = "Partner.finyById";
    public static final String COUNT = "Partner.count";
    public static final String NAME = "name";
    public static final String IS_TECHNICAL = "technical";
    public static final String APPLY_CRITERIA = "applyCriteria";
    public static final String ID = "id";

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

    // @Embedded
    // private PartnerContact contact;
    //
    // @OneToMany(mappedBy = "party", fetch = FetchType.LAZY, targetEntity =
    // Expense.class)
    // private Set<Expense> expenses;
    //
    // @OneToMany(mappedBy = "party", fetch = FetchType.LAZY, targetEntity =
    // Income.class)
    // private Set<Income> incomes;

    public Partner() {
    }

    // public Partner(Integer id, String name, String account, boolean technical,
    // final String cName, final String cEmail,
    // final String cPhone) {
    // if (id != null)
    // id = id;
    // name = name;
    // account = account;
    // technical = technical;
    // contact = new PartnerContact(cName, cEmail, cPhone);
    // }

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

    // public PartnerContact getContact() {
    // return contact;
    // }
    //
    // public void setContact(PartnerContact contact) {
    // contact = contact;
    // }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    // public Set<Expense> getExpenses() {
    // return expenses;
    // }
    //
    // public void setExpenses(Set<Expense> expenses) {
    // expenses = expenses;
    // }

    /**
     * bidirectional
     *
     * @param expense
     * @return
     */
    // public Expense addExpense(final Expense expense) {
    // getExpenses().add(expense);
    // expense.setParty(this);
    //
    // return expense;
    // }

    /**
     * bidirectional
     *
     * @param expense
     * @return
     */
    // public Expense removeExpense(final Expense expense) {
    // getExpenses().remove(expense);
    // expense.setParty(null);
    //
    // return expense;
    // }

    // public Set<Income> getIncomes() {
    // return incomes;
    // }
    //
    // public void setIncomes(Set<Income> incomes) {
    // incomes = incomes;
    // }

    /**
     * bidirectional
     *
     * @param income
     * @return
     */
    // public Income addIncome(final Income income) {
    // getIncomes().add(income);
    // income.setParty(this);
    //
    // return income;
    // }

    /**
     * bidirectional
     *
     * @param income
     * @return
     */
    // public Income removeIncome(final Income income) {
    // getIncomes().remove(income);
    // income.setParty(null);
    //
    // return income;
    // }

    /**
     * Updates partner data field by field
     *
     * @param partner
     */
    // public void update(final Partner partner) {
    // this.setName(partner.getName());
    // this.setAccount(partner.getAccount());
    // this.setParnterTechnical(partner.getParnterTechnical());
    // this.setContact(partner.getContact());
    // }
}
