package hu.restoffice.transaction.service;

import java.util.List;

import hu.restoffice.commons.CRUDService;
import hu.restoffice.commons.ServiceException;
import hu.restoffice.transaction.entity.IncomeType;

/**
 *
 */
public interface IncomeTypeService extends CRUDService<IncomeType> {

    IncomeType findByName(String name) throws ServiceException;

    List<IncomeType> findAll(final Boolean prodRealted) throws ServiceException;
}
