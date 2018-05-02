package hu.restoffice.cashregister.service;

import hu.restoffice.cashregister.entity.Register;
import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.service.CRUDService;

/**
 *
 */
public interface RegisterService extends CRUDService<Register> {

    Register findByRegistrationNo(String regNo) throws ServiceException;
}