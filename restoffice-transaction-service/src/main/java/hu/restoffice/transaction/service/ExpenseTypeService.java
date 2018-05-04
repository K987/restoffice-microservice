package hu.restoffice.transaction.service;

import java.util.List;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.service.CRUDService;
import hu.restoffice.transaction.entity.ExpenseType;

/**
 *
 */
public interface ExpenseTypeService extends CRUDService<ExpenseType> {

    ExpenseType findByName(String name) throws ServiceException;

    List<ExpenseType> findAll(final Boolean prodRealted) throws ServiceException;
}
