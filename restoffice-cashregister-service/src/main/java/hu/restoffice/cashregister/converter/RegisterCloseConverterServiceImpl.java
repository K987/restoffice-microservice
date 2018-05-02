package hu.restoffice.cashregister.converter;

import org.springframework.stereotype.Service;

import hu.restoffice.cashregister.domain.RegisterCloseStub;
import hu.restoffice.cashregister.entity.RegisterClose;

/**
 *
 */
@Service
public class RegisterCloseConverterServiceImpl implements RegisterCloseConverterService {

    /* (non-Javadoc)
     * @see hu.restoffice.commons.DefaultConverterService#from(java.lang.Object)
     */
    @Override
    public RegisterCloseStub from(final RegisterClose entity) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see hu.restoffice.commons.DefaultConverterService#to(java.lang.Object)
     */
    @Override
    public RegisterClose to(final RegisterCloseStub stub) {
        // TODO Auto-generated method stub
        return null;
    }

}
