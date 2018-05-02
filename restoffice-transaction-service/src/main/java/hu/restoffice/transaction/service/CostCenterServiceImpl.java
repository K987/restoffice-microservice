package hu.restoffice.transaction.service;

import org.springframework.stereotype.Service;

import hu.restoffice.commons.AbstractCRUDService;
import hu.restoffice.commons.ServiceException;
import hu.restoffice.commons.ServiceException.Type;
import hu.restoffice.transaction.entity.CostCenter;
import hu.restoffice.transaction.repository.CostCenterRepository;

/**
 *
 */
@Service
public class CostCenterServiceImpl extends AbstractCRUDService<CostCenter, CostCenterRepository> implements CostCenterService {

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.service.CostCenterService#getDefault()
     */
    @Override
    public CostCenter getDefault() throws ServiceException {
        return repo.findDefault().orElseThrow(() -> new ServiceException(Type.NOT_EXISTS, "no default cost center"));
    }

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.service.CostCenterService#findByName(java.lang.String)
     */
    @Override
    public CostCenter findByName(final String name) throws ServiceException{
        return repo.findByNameIgnoreCase(name)
                .orElseThrow(() -> new ServiceException(Type.NOT_EXISTS, "CostCenter does not exists", name));
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.service.AbstractCRUDService#checkExistence(java.
     * lang.Object)
     */
    @Override
    protected boolean checkExistence(final CostCenter entity) {
        return repo.findByNameIgnoreCase(entity.getName()).isPresent();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.service.AbstractCRUDService#updateFields(java.lang.
     * Object, java.lang.Object)
     */
    @Override
    protected void updateFields(final CostCenter old, final CostCenter entity) {
        String name = entity.getName();
        Boolean def = entity.isDefault();

        if (name != null) {
            old.setName(name);
        }
        if (def != null) {
            old.setDefault(def);
        }

    }


}
