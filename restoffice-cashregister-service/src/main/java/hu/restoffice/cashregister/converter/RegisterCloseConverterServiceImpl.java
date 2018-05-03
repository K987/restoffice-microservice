package hu.restoffice.cashregister.converter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Component;

import hu.restoffice.cashregister.domain.RegisterCloseStub;
import hu.restoffice.cashregister.entity.Register;
import hu.restoffice.cashregister.entity.RegisterClose;

/**
 *
 */
@Component
public class RegisterCloseConverterServiceImpl implements RegisterCloseConverterService {

    private LocalDate initLocalDate(final Date date) {
        return Optional.ofNullable(date).map(Date::toLocalDate).orElse(null);
    }

    /* (non-Javadoc)
     * @see hu.restoffice.commons.DefaultConverterService#from(java.lang.Object)
     */
    @Override
    public RegisterCloseStub from(final RegisterClose entity) {
        Register r = entity.getRegister();
        String registerNo = r != null ? r.getRegistrationNo() : null;
        Long regId = r != null ? r.getId() : null;
        return new RegisterCloseStub(entity.getId(), entity.getCloseNo(),
                entity.getClosingAmount(), initLocalDate(entity.getCloseDate()), registerNo, regId);
    }

    /*
     * (non-Javadoc)
     *
     * @see hu.restoffice.commons.DefaultConverterService#to(java.lang.Object)
     */
    @Override
    public RegisterClose to(final RegisterCloseStub stub) {
        RegisterClose register = new RegisterClose();
        register.setClosingAmount(stub.getClosingAmount());
        register.setCloseDate(Date.valueOf(stub.getCloseDate()));
        register.setCloseNo(stub.getCloseNo());
        Register r = new Register();
        r.setRegistrationNo(stub.getRegisterRegistrationNo());
        register.setRegister(r);

        return register;
    }

}
