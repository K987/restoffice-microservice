package hu.restoffice.transaction.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
public class PartnerStub {

    @JsonProperty
    private Long id;
    @NotBlank
    @JsonProperty
    private String name;
    @JsonProperty
    private String account;
    @JsonProperty
    private String contactName;
    @Pattern(regexp = "^\\\\(?(\\\\d{2})\\\\)?[- ]?(\\\\d{3})[- ]?(\\\\d{4})$", message = "invalid phone number")
    @JsonProperty
    private String contactPhone;
    @Email(message = "invalid email address")
    @JsonProperty
    private String contactEmail;
    @NotNull
    @JsonProperty
    private Boolean technical;

    /**
     *
     */
    public PartnerStub() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param id
     * @param name
     * @param account
     * @param contactName
     * @param contactPhone
     * @param contactEmail
     * @param technical
     */
    public PartnerStub(final Long id, final String name, final String account, final String contactName,
            final String contactPhone, final String contactEmail, final Boolean technical) {
        super();
        this.id = id;
        this.name = name;
        this.account = account;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.technical = technical;
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
     * @return the account
     */
    public String getAccount() {
        return account;
    }

    /**
     * @return the contactName
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * @return the contactPhone
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * @return the contactEmail
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     * @return the technical
     */
    public Boolean getTechnical() {
        return technical;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PartnerStub [id=" + id + ", name=" + name + ", account=" + account + ", contactName=" + contactName
                + ", contactPhone=" + contactPhone + ", contactEmail=" + contactEmail + ", technical=" + technical
                + "]";
    }

}
