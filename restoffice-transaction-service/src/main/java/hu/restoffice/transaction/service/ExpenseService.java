package hu.restoffice.transaction.service;

import java.util.List;

import hu.restoffice.transaction.entity.Expense;
import hu.restoffice.transaction.error.ServiceException;

/**
 *
 */
public interface ExpenseService extends CRUDService<Expense> {

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.service.ExpenseSerivce#add(hu.restoffice.transaction.entity.Expense)
     */
    @Override
    Expense add(Expense entity) throws ServiceException;

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.service.ExpenseSerivce#searchByExample(hu.restoffice.transaction.entity.Expense)
     */
    List<Expense> searchByExample(Expense expense) throws ServiceException;

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.service.ExpenseSerivce#findyByDocId(java.lang.String)
     */
    Expense findyByDocId(String docId) throws ServiceException;

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.service.ExpenseSerivce#update(java.lang.Long, hu.restoffice.transaction.entity.Expense)
     */
    @Override
    Expense update(Long id, Expense entity) throws ServiceException;

}