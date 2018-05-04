package hu.restoffice.transaction.entity;

import javax.persistence.Column;

/**
 *
 */
public class PartnerContact {

    @Column(name = "partner_contact_name")
    private String name;

    @Column(name = "partner_contact_phone")
    private String phone;


    @Column(name = "partner_contact_email")
    private String email;

    public PartnerContact() {

    }

    /**
     * @param name
     * @param email
     * @param phone
     */
    public PartnerContact(final String name, final String email, final String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     *            the phone to set
     */
    public void setPhone(final String phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PartnerContact [name=" + name + ", phone=" + phone + ", email=" + email + "]";
    }
}
