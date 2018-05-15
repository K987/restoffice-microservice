package hu.restoffice.dailyclose.converter;

import org.springframework.stereotype.Component;

import hu.restoffice.dailyclose.domain.RegisterDailyCloseStub;
import hu.restoffice.dailyclose.entity.RegisterDailyClose;

/**
 *
 */
@Component
public class RegisterDailyCloseConverterImpl implements RegisterDailyCloseConverter {

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.commons.service.DefaultConverterService#from(java.lang.Object)
     */
    @Override
    public RegisterDailyCloseStub from(final RegisterDailyClose entity) {
        return new RegisterDailyCloseStub(entity.getId(), entity.getType(), entity.getCloseTotal());
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.commons.service.DefaultConverterService#to(java.lang.Object)
     */
    @Override
    public RegisterDailyClose to(final RegisterDailyCloseStub stub) {
        RegisterDailyClose rtrn = new RegisterDailyClose();
        rtrn.setType(stub.getType());
        rtrn.setCloseTotal(stub.getCloseTotal());
        return rtrn;

    }

}
