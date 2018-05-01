package hu.restoffice.transaction.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 */
public class ExpenseTypeStub {

    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private Boolean prodRelated;

    /**
     * @param id
     * @param name
     * @param prodRelated
     */
    public ExpenseTypeStub(final Long id, @NotBlank final String name, @NotNull final Boolean prodRelated) {
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
    public Boolean getProdRelated() {
        return prodRelated;
    }

}
