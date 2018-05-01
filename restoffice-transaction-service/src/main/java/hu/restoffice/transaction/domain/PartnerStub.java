package hu.restoffice.transaction.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 */
public class PartnerStub {

    private final Long id;
    @NotBlank
    private final String name;
    private final String account;
    private final String contactName;
    @Pattern(regexp = "^\\\\(?(\\\\d{2})\\\\)?[- ]?(\\\\d{3})[- ]?(\\\\d{4})$", message = "invalid phone number")
    private final String contactPhone;
    @Email(message = "invalid email address")
    private final String contactEmail;
    @NotNull
    private final Boolean technical;

    /**
     * @param id
     * @param name
     * @param account
     * @param contactName
     * @param contactPhone
     * @param contactEmail
     * @param technical
     */
    public PartnerStub(final Long id, @NotBlank final String name, final String account, final String contactName,
            final String contactPhone, final String contactEmail, @NotNull final Boolean technical) {
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

}
