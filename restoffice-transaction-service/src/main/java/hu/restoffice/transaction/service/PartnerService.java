package hu.restoffice.transaction.service;

import java.util.List;

import hu.restoffice.transaction.entity.Partner;
import hu.restoffice.transaction.error.ServiceException;

/**
 *
 */
public interface PartnerService {

    Partner add(final Partner partner) throws ServiceException;

    Partner update(final Long partnerId, final Partner partner) throws ServiceException;

    Partner findByName(final String patnerName) throws ServiceException;

    Partner findyById(final Long partnerId) throws ServiceException;

    Partner delete(final Long partnerId) throws ServiceException;

    List<Partner> findAll(final Boolean technical) throws ServiceException;

    List<Partner> deleteUnused() throws ServiceException;

    List<Partner> serachByName(String name);

}
