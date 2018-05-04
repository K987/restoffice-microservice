package hu.restoffice.transaction.service;

import java.util.List;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.service.CRUDService;
import hu.restoffice.transaction.entity.Partner;
import hu.restoffice.transaction.entity.PartnerContact;

/**
 *
 */
public interface PartnerService extends CRUDService<Partner> {

    List<Partner> findAll(final Boolean technical) throws ServiceException;

    Partner findByName(final String partnerName) throws ServiceException;

    List<Partner> serachByName(String name) throws ServiceException;

    List<Partner> deleteNotUsed() throws ServiceException;

    PartnerContact getContact(Long partnerId) throws ServiceException;

    Partner updateContact(Long id, PartnerContact contact) throws ServiceException;

    Partner deleteContact(Long partnerId) throws ServiceException;

}
