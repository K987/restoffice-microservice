package hu.restoffice.transaction.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 */
public class CostCenterStub {

    private Long id;
    @NotNull
    private Boolean defaultCostCenter;
    @NotBlank
    private String name;

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

}
