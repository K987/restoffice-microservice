package hu.restoffice.cashregister.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.restoffice.cashregister.domain.RegisterCloseStub;
import hu.restoffice.cashregister.domain.RegisterStub;
import hu.restoffice.cashregister.entity.Register;

/**
 *
 */
@Component
public class RegisterConverterServiceImpl implements RegisterConverterService {

    private static final Logger log = LogManager.getLogger();

    @Autowired
    private RegisterCloseConverterService registerCloseConverter;
    /* (non-Javadoc)
     * @see hu.restoffice.commons.DefaultConverterService#from(java.lang.Object)
     */
    @Override
    public RegisterStub from(final Register entity) {

        return new RegisterStub(entity.getId(), entity.getRegistrationNo(), entity.getRegisterType(),
                fromRegisterClose(entity));
    }

    /*
     * (non-Javadoc)
     *
     * @see hu.restoffice.commons.DefaultConverterService#to(java.lang.Object)
     */
    @Override
    public Register to(final RegisterStub stub) {
        Register reg = new Register();
        reg.setRegisterType(stub.getRegisterType());
        reg.setRegistrationNo(Optional.ofNullable(stub.getRegistrationNo()).map(s -> s.trim()).orElse(null));
        return reg;
    }


    /**
     * @param registerCloses
     * @return
     */
    private List<RegisterCloseStub> fromRegisterClose(final Register register) {
        if (!Hibernate.isInitialized(register.getRegisterCloses()) || register.getRegisterCloses() == null) {
            log.info("register close not inited");
            return new ArrayList<>();
        }
        else {
            log.info("register close inited");
            return registerCloseConverter.from(new ArrayList<>(register.getRegisterCloses()));
        }

    }
}
