package hu.restoffice.transaction.service;

import java.util.List;

import hu.restoffice.transaction.entity.Income;
import hu.restoffice.transaction.error.ServiceException;

/**
 *
 */
public interface IncomeService extends CRUDService<Income> {

    @Override
    Income add(Income entity) throws ServiceException;

    List<Income> searchByExample(Income income) throws ServiceException;

    Income findyByDocId(String docId) throws ServiceException;

    @Override
    Income update(Long id, Income entity) throws ServiceException;

}