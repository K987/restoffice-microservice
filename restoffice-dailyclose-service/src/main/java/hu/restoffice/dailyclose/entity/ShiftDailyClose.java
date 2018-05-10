package hu.restoffice.dailyclose.entity;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name="shift_daily_closes")
public class ShiftDailyClose implements Serializable, Identity {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SHIFT_DAILY_CLOSE_ID_GENERATOR", sequenceName = "SHIFT_DAILY_CLOSE_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SHIFT_DAILY_CLOSE_ID_GENERATOR")
    @Column(name = "shift_daily_close_id")
    private Long id;

    @Column(name = "shift_daily_close_employee_id", nullable = false)
    private Long employeeId;

    @Column(name = "shift_daily_close_employee_name")
    private String employeeName;

    @Column(name = "shift_daily_close_pos_total")
    private BigDecimal posTotal;

    @Column(name = "shift_daily_close_card_total")
    private BigDecimal cardTotal;

    @Column(name = "shift_daily_close_cash_total")
    private BigDecimal cashTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shift_daily_close_daily_close_id")
    private DailyClose dailyClose;

    /**
     *
     */
    public ShiftDailyClose() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the employeeId
     */
    public Long getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId
     *            the employeeId to set
     */
    public void setEmployeeId(final Long employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return the employeeName
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * @param employeeName
     *            the employeeName to set
     */
    public void setEmployeeName(final String employeeName) {
        this.employeeName = employeeName;
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

    /**
     * @return the id
     */
    @Override
    public Long getId() {
        return id;
    }

}
