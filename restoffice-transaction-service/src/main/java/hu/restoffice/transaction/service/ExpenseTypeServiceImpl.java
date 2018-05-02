package hu.restoffice.transaction.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hu.restoffice.commons.AbstractCRUDService;
import hu.restoffice.commons.ServiceException;
import hu.restoffice.commons.ServiceException.Type;
import hu.restoffice.transaction.entity.ExpenseType;
import hu.restoffice.transaction.repository.ExpenseTypeRepository;

/**
 *
 */
@Service
public class ExpenseTypeServiceImpl extends AbstractCRUDService<ExpenseType, ExpenseTypeRepository>
implements ExpenseTypeService {


    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.service.IncomeTypeService#findByName(java.lang.
     * String)
     */
    @Override
    public ExpenseType findByName(final String name) throws ServiceException {
        return repo.findByNameIgnoreCase(name)
                .orElseThrow(() -> new ServiceException(Type.NOT_EXISTS,
                        "entity with name does not exists, you might want to create it", name));
    }

    /*
     * (non-Javadoc)
     *
     * @see hu.restoffice.transaction.service.IncomeTypeService#findAll(java.lang.
     * Boolean)
     */
    @Override
    public List<ExpenseType> findAll(final Boolean prodRealted) throws ServiceException {
        return repo.findByProdRelated(prodRealted);
    }

    /*
     * (non-Javadoc)
     *
     * @see hu.restoffice.transaction.service.CRUDService#checkExistence(java.lang.
     * Object)
     */
    @Override
    protected boolean checkExistence(final ExpenseType entity) {
        return repo.findByNameIgnoreCase(entity.getName()).isPresent();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.service.CRUDService#updateFields(java.lang.Object,
     * java.lang.Object)
     */
    @Override
    protected void updateFields(final ExpenseType old, final ExpenseType entity) {
        String name = entity.getName();
        Boolean prodRelated = entity.isProdRelated();

        if (name != null)
            old.setName(name);
        if (prodRelated != null)
            old.setProdRelated(prodRelated);
    }

}
