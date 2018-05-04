package hu.restoffice.transaction.entity;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Embeddable;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

/**
 *
 */
@Embeddable
public class AccountingPeriod {

    private Date startDate;

    private Date endDate;

    @Transient
    private Integer monthsBetween;

    public AccountingPeriod() {

    }

    /**
     * @param startDate
     * @param endDate
     */
    public AccountingPeriod(final Date startDate, final Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @PostLoad
    protected void setMonths() {

        monthsBetween = 1;
        if (startDate != null && endDate != null && endDate.getTime() >= startDate.getTime()) {
            Calendar start = Calendar.getInstance();
            Calendar end = Calendar.getInstance();
            start.setTime(startDate);
            end.setTime(endDate);
            int years = end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
            int months = years * 12 + end.get(Calendar.MONTH) - end.get(Calendar.MONTH);
            monthsBetween += months;
        }
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate
     *            the startDate to set
     */
    public void setStartDate(final Date startDate) {
        this.startDate = startDate;
        setMonths();
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate
     *            the endDate to set
     */
    public void setEndDate(final Date endDate) {
        this.endDate = endDate;
        setMonths();
    }

    /**
     * @return the monthsBetween
     */
    public int getPeriodLength() {
        if (monthsBetween == null) {
            setMonths();
        }
        return monthsBetween;
    }
}