package hu.restoffice.dailyclose.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import hu.restoffice.commons.entity.Identity;
import hu.restoffice.dailyclose.client.RegisterType;

/**
 *
 */
@Entity
@Table(name = "register_daily_closes")
public class RegisterDailyClose implements Serializable, Identity {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "register_daily_close_id_generator", sequenceName = "register_daily_close_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "register_daily_close_id_generator")
    @Column(name = "register_daily_close_id")
    private Long id;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "register_daily_close_register_type")
    private RegisterType type;

    @Column(name = "register_daily_close_total")
    private BigDecimal closeTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "register_daily_close_daily_close", referencedColumnName = "daily_close_id")
    private DailyClose dailyClose;

    /**
     *
     */
    public RegisterDailyClose() {
    }

    /**
     * @return the id
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * @return the type
     */
    public RegisterType getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(final RegisterType type) {
        this.type = type;
    }

    /**
     * @return the closeTotal
     */
    public BigDecimal getCloseTotal() {
        return closeTotal;
    }

    /**
     * @param closeTotal
     *            the closeTotal to set
     */
    public void setCloseTotal(final BigDecimal closeTotal) {
        this.closeTotal = closeTotal;
    }

    /**
     * @return the dailyClose
     */
    public DailyClose getDailyClose() {
        return dailyClose;
    }

    /**
     * @param dailyClose
     *            the dailyClose to set
     */
    public void setDailyClose(final DailyClose dailyClose) {
        this.dailyClose = dailyClose;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "RegisterDailyClose [id=" + id + ", type=" + type + ", closeTotal=" + closeTotal + ", dailyClose="
                + dailyClose + "]";
    }

}
