package hu.restoffice.transaction.service;

import java.util.List;

import hu.restoffice.commons.CRUDService;
import hu.restoffice.commons.ServiceException;
import hu.restoffice.transaction.entity.Income;

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