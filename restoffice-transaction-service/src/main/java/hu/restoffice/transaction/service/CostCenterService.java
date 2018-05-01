package hu.restoffice.transaction.service;

import hu.restoffice.transaction.entity.CostCenter;
import hu.restoffice.transaction.error.ServiceException;

/**
 *
 */
public interface CostCenterService extends CRUDService<CostCenter> {

    CostCenter getDefault() throws ServiceException;

    CostCenter findByName(String name) throws ServiceException;

}