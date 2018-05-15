package hu.restoffice.dailyclose.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
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

/**
 *
 */
@Entity
@Table(name = "daily_closes")
public class DailyClose implements Serializable, Identity {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "daily_close_id_generator", sequenceName = "daily_close_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "daily_close_id_generator")
    @Column(name = "daily_close_id")
    private Long id;

    @Column(name = "daily_close_close_dt")
    private Date closeDate;

    @Column(name = "daily_close_pos_total")
    private BigDecimal posTotal;

    @Column(name = "daily_close_card_total")
    private BigDecimal cardTotal;

    @Column(name = "daily_close_cash_total")
    private BigDecimal cashTotal;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "dailyClose")
    private Set<RegisterDailyClose> registerDailyCloses;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "dailyClose")
    private Set<ShiftDailyClose> shiftDailyCloses;

    /**
     *
     */
    public DailyClose() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the closeDate
     */
    public Date getCloseDate() {
        return closeDate;
    }

    /**
     * @param closeDate
     *            the closeDate to set
     */
    public void setCloseDate(final Date closeDate) {
        this.closeDate = closeDate;
    }

    /**
     * @return the posTotal
     */
    public BigDecimal getPosTotal() {
        return posTotal;
    }

    /**
     * @param posTotal
     *            the posTotal to set
     */
    public void setPosTotal(final BigDecimal posTotal) {
        this.posTotal = posTotal;
    }

    /**
     * @return the cardTotal
     */
    public BigDecimal getCardTotal() {
        return cardTotal;
    }

    /**
     * @param cardTotal
     *            the cardTotal to set
     */
    public void setCardTotal(final BigDecimal cardTotal) {
        this.cardTotal = cardTotal;
    }

    /**
     * @return the cashTotal
     */
    public BigDecimal getCashTotal() {
        return cashTotal;
    }

    /**
     * @param cashTotal
     *            the cashTotal to set
     */
    public void setCashTotal(final BigDecimal cashTotal) {
        this.cashTotal = cashTotal;
    }

    /**
     * @return the registerDailyCloses
     */
    public Set<RegisterDailyClose> getRegisterDailyCloses() {
        return registerDailyCloses;
    }

    /**
     * @param registerDailyCloses
     *            the registerDailyCloses to set
     */
    public void setRegisterDailyCloses(final Set<RegisterDailyClose> registerDailyCloses) {
        this.registerDailyCloses = registerDailyCloses;
    }

    /**
     * @return the shiftDailyCloses
     */
    public Set<ShiftDailyClose> getShiftDailyCloses() {
        return shiftDailyCloses;
    }

    /**
     * @param shiftDailyCloses
     *            the shiftDailyCloses to set
     */
    public void setShiftDailyCloses(final Set<ShiftDailyClose> shiftDailyCloses) {
        this.shiftDailyCloses = shiftDailyCloses;
    }

    /**
     * @return the id
     */
    @Override
    public Long getId() {
        return id;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "DailyClose [id=" + id + ", closeDate=" + closeDate + ", posTotal=" + posTotal + ", cardTotal="
                + cardTotal + ", cashTotal=" + cashTotal + "]";
    }

}

