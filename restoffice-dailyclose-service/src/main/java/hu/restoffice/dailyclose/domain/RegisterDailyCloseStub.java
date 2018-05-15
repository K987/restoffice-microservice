package hu.restoffice.dailyclose.domain;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import hu.restoffice.dailyclose.client.RegisterType;

/**
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RegisterDailyCloseStub {

    @JsonProperty
    private Long id;
    @JsonProperty
    private RegisterType type;
    @JsonProperty
    private BigDecimal closeTotal;

    /**
     *
     */
    public RegisterDailyCloseStub() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param id
     * @param type
     * @param closeTotal
     */
    public RegisterDailyCloseStub(final Long id, final RegisterType type, final BigDecimal closeTotal) {
        this.type = type;
        this.closeTotal = closeTotal;
    }

    /**
     * @return the id
     */
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
     * @return the closeTotal
     */
    public BigDecimal getCloseTotal() {
        return closeTotal;
    }

    public void add(final BigDecimal bd) {
        closeTotal = closeTotal.add(bd);
    }
    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "RegisterDailyCloseStub [id=" + id + ", type=" + type + ", closeTotal=" + closeTotal + "]";
    }
}
