package hu.restoffice.transaction.service;

import java.util.List;

import hu.restoffice.transaction.entity.ExpenseType;
import hu.restoffice.transaction.error.ServiceException;

/**
 *
 */
public interface ExpenseTypeService extends CrudService<ExpenseType> {

    ExpenseType findByName(String name) throws ServiceException;

    List<ExpenseType> findAll(final Boolean prodRealted) throws ServiceException;
}
