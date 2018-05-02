package hu.restoffice.cashregister.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.restoffice.cashregister.domain.RegisterCloseStub;
import hu.restoffice.cashregister.domain.RegisterStub;
import hu.restoffice.cashregister.entity.Register;
import hu.restoffice.cashregister.entity.RegisterClose;

/**
 *
 */
@Service
public class RegisterConverterServiceImpl implements RegisterConverterService {

    @Autowired
    private RegisterCloseConverterService registerCloseConverter;
    /* (non-Javadoc)
     * @see hu.restoffice.commons.DefaultConverterService#from(java.lang.Object)
     */
    @Override
    public RegisterStub from(final Register entity) {

        return new RegisterStub(entity.getId(), entity.getRegistrationNo(), entity.getRegisterType(),
                fromRegisterClose(entity.getRegisterCloses()));
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
    private List<RegisterCloseStub> fromRegisterClose(final Set<RegisterClose> registerCloses) {
        if (registerCloses == null)
            return new ArrayList<>();
        else {
            return registerCloseConverter.from(new ArrayList<>(registerCloses));
        }

    }
}
