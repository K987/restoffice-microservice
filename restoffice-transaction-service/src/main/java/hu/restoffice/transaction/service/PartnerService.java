package hu.restoffice.transaction.service;

import java.util.List;

import hu.restoffice.transaction.entity.Partner;
import hu.restoffice.transaction.entity.PartnerContact;
import hu.restoffice.transaction.error.ServiceException;

/**
 *
 */
public interface PartnerService extends CrudService<Partner> {

    List<Partner> findAll(final Boolean technical) throws ServiceException;

    Partner findByName(final String partnerName) throws ServiceException;

    List<Partner> serachByName(String name) throws ServiceException;

    List<Partner> deleteNotUsed() throws ServiceException;

    PartnerContact getContact(Long partnerId) throws ServiceException;

    Partner updateContact(Long id, PartnerContact contact) throws ServiceException;

    Partner deleteContact(Long partnerId) throws ServiceException;

}
