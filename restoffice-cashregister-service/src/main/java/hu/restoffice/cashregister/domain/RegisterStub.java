package hu.restoffice.cashregister.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
@JsonInclude(Include.NON_EMPTY)
public class RegisterStub {

    @JsonProperty
    private Long id;
    @JsonProperty
    private String registrationNo;
    @JsonProperty
    private RegisterType registerType;
    @JsonProperty
    private List<RegisterCloseStub> registerClose;

    public RegisterStub() {

    }

    /**
     * @param id
     * @param registrationNo
     * @param registerType
     * @param registerClose
     */
    public RegisterStub(final Long id, final String registrationNo, final RegisterType registerType,
            final List<RegisterCloseStub> registerClose) {
        super();
        this.id = id;
        this.registrationNo = registrationNo;
        this.registerType = registerType;
        this.registerClose = registerClose;
    }


    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the registrationNo
     */
    public String getRegistrationNo() {
        return registrationNo;
    }

    /**
     * @return the registerType
     */
    public RegisterType getRegisterType() {
        return registerType;
    }

    /**
     * @return the registerClose
     */
    public List<RegisterCloseStub> getRegisterClose() {
        return registerClose;
    }
}
