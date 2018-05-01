package hu.restoffice.transaction.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 */
public class IncomeTypeStub {

    private final Long id;
    @NotBlank
    private final String name;
    @NotNull
    private final Boolean prodRelated;

    /**
     * @param id
     * @param name
     * @param prodRelated
     */
    public IncomeTypeStub(final Long id, @NotBlank final String name, @NotNull final Boolean prodRelated) {
        super();
        this.id = id;
        this.name = name;
        this.prodRelated = prodRelated;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the prodRelated
     */
    public Boolean isProdRelated() {
        return prodRelated;
    }

}
