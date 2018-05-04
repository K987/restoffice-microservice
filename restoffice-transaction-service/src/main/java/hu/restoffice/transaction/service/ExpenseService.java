package hu.restoffice.transaction.service;

import java.util.List;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.service.CRUDService;
import hu.restoffice.transaction.entity.Expense;

/**
 *
 */
public interface ExpenseService extends CRUDService<Expense> {

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.service.ExpenseSerivce#searchByExample(hu.restoffice.transaction.entity.Expense)
     */
    List<Expense> searchByExample(Expense expense) throws ServiceException;

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.service.ExpenseSerivce#findyByDocId(java.lang.String)
     */
    Expense findyByDocId(String docId) throws ServiceException;

}