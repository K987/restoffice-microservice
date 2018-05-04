package hu.restoffice.transaction.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
public class CostCenterStub {

    @JsonProperty
    private Long id;
    @NotNull
    @JsonProperty
    private Boolean defaultCostCenter;
    @NotBlank
    @JsonProperty
    private String name;

    /**
     *
     */
    public CostCenterStub() {
        super();
    }

    /**
     * @param id
     * @param defaultCostCenter
     * @param name
     */
    public CostCenterStub(final Long id, @NotNull final Boolean defaultCostCenter, @NotBlank final String name) {
        super();
        this.id = id;
        this.defaultCostCenter = defaultCostCenter;
        this.name = name;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the defaultCostCenter
     */
    public Boolean getDefaultCostCenter() {
        return defaultCostCenter;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CostCenterStub [id=" + id + ", defaultCostCenter=" + defaultCostCenter + ", name=" + name + "]";
    }

}
