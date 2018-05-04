package hu.restoffice.transaction.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
public class ExpenseTypeStub {

    @JsonProperty
    private Long id;
    @NotBlank
    @JsonProperty
    private String name;
    @NotNull
    @JsonProperty
    private Boolean prodRelated;

    /**
     *
     */
    public ExpenseTypeStub() {
        // TODO Auto-generated constructor stub
    }

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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ExpenseTypeStub [id=" + id + ", name=" + name + ", prodRelated=" + prodRelated + "]";
    }

}
