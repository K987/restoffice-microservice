package hu.restoffice.transaction.service;

import java.util.List;

import hu.restoffice.commons.CRUDService;
import hu.restoffice.commons.ServiceException;
import hu.restoffice.transaction.entity.ExpenseType;

/**
 *
 */
public interface ExpenseTypeService extends CRUDService<ExpenseType> {

    ExpenseType findByName(String name) throws ServiceException;

    List<ExpenseType> findAll(final Boolean prodRealted) throws ServiceException;
}
