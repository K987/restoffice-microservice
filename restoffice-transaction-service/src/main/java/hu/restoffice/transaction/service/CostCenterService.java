package hu.restoffice.transaction.service;

import hu.restoffice.commons.CRUDService;
import hu.restoffice.commons.ServiceException;
import hu.restoffice.transaction.entity.CostCenter;

/**
 *
 */
public interface CostCenterService extends CRUDService<CostCenter> {

    CostCenter getDefault() throws ServiceException;

    CostCenter findByName(String name) throws ServiceException;

}