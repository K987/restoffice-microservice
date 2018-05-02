package hu.restoffice.cashregister.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

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

/**
 *
 */
@Entity
@Table(name = "register_closes")
public class RegisterClose implements Serializable {

    private static final long serialVersionUID = -5780679899641241491L;

    @Id
    @Column(name = "register_close_id")
    @SequenceGenerator(name = "REGISTER_CLOSES_REGISTER_CLOSE_ID_GENERATOR", sequenceName = "REGISTER_CLOSES_REGISTER_CLOSE_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REGISTER_CLOSES_REGISTER_CLOSE_ID_GENERATOR")

    private Long id;

    @Column(name = "register_close_no", unique = true, nullable = false)
    private Long closeNo;

    @Column(name = "register_close_amt", precision = 131089)
    private BigDecimal closingAmount;

    @Column(name = "register_close_date", nullable = false)
    private Date closeDate;

    // bi-directional many-to-one association to Register
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "register_close_register_id", referencedColumnName = "register_id", nullable = false)
    private Register register;

    public RegisterClose() {
    }

    public Long getId() {
        return id;
    }

    public Long getCloseNo() {
        return closeNo;
    }

    public void setCloseNo(final Long closeNo) {
        this.closeNo = closeNo;
    }

    public BigDecimal getloseAmt() {
        return closingAmount;
    }

    public void setCloseAmt(final BigDecimal registerCloseAmt) {
        closingAmount = registerCloseAmt;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(final Date registerCloseDate) {
        closeDate = registerCloseDate;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(final Register register) {
        this.register = register;
    }

}

