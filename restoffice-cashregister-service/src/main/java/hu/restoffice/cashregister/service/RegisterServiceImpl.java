package hu.restoffice.cashregister.service;

import org.springframework.stereotype.Service;

import hu.restoffice.cashregister.domain.RegisterType;
import hu.restoffice.cashregister.entity.Register;
import hu.restoffice.cashregister.repository.RegisterRepository;
import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.error.ServiceException.Type;
import hu.restoffice.commons.service.AbstractCRUDService;

/**
 *
 */
@Service
public class RegisterServiceImpl extends AbstractCRUDService<Register, RegisterRepository> implements RegisterService {

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.commons.AbstractCRUDService#checkExistence(java.lang.Object)
     */
    @Override
    protected boolean checkExistence(final Register entity) throws ServiceException {
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

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.cashregister.service.RegisterService#findByRegistrationNo(java.
     * lang.String)
     */
    @Override
    public Register findByRegistrationNo(final String regNo) throws ServiceException {
        return repo.findByRegistrationNoIgnoreCase(regNo)
                .orElseThrow(() -> new ServiceException(Type.NOT_EXISTS, regNo));
    }

    @Override
    protected boolean isDeletable(final Long id) throws ServiceException {
        return (repo.hasCloses(id) == 0);
    }

}
