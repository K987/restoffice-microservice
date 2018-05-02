package hu.restoffice.cashregister.service;

import org.springframework.stereotype.Service;

import hu.restoffice.cashregister.domain.RegisterType;
import hu.restoffice.cashregister.entity.Register;
import hu.restoffice.cashregister.repository.RegisterRepository;
import hu.restoffice.commons.AbstractCRUDService;

/**
 *
 */
@Service
public class RegisterServiceImpl extends AbstractCRUDService<Register, RegisterRepository>
implements RegisterService {


    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.commons.AbstractCRUDService#checkExistence(java.lang.Object)
     */
    @Override
    protected boolean checkExistence(final Register entity) {
        return repo.findByRegistrationNoIgnoreCase(entity.getRegistrationNo()).isPresent();
    }

    /*
     * (non-Javadoc)
     *
     * @see hu.restoffice.commons.AbstractCRUDService#updateFields(java.lang.Object,
     * java.lang.Object)
     */
    @Override
    protected void updateFields(final Register old, final Register entity) {
        RegisterType type = entity.getRegisterType();
        String regNo = entity.getRegistrationNo();

        if (type != null) {
            old.setRegisterType(type);
        }
        if (regNo != null && regNo.trim().length() != 0) {
            old.setRegistrationNo(regNo);
        }

    }

}
