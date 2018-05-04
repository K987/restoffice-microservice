package hu.restoffice.transaction.service;

import java.util.List;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.service.CRUDService;
import hu.restoffice.transaction.entity.Income;

/**
 *
 */
public interface IncomeService extends CRUDService<Income> {

    List<Income> searchByExample(Income income) throws ServiceException;

    Income findyByDocId(String docId) throws ServiceException;


}