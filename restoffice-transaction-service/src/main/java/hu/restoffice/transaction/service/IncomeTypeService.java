package hu.restoffice.transaction.service;

import java.util.List;

import hu.restoffice.transaction.entity.IncomeType;
import hu.restoffice.transaction.error.ServiceException;

/**
 *
 */
public interface IncomeTypeService extends CRUDService<IncomeType> {

    IncomeType findByName(String name) throws ServiceException;

    List<IncomeType> findAll(final Boolean prodRealted) throws ServiceException;
}
