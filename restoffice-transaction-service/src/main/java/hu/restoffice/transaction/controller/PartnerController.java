package hu.restoffice.transaction.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import hu.restoffice.transaction.entity.Partner;
import hu.restoffice.transaction.entity.PartnerContact;
import hu.restoffice.transaction.error.ServiceException;

/**
 *
 */
public interface PartnerController {

    ResponseEntity<List<Partner>> findAll() throws ServiceException;

    ResponseEntity<?> create(Partner partner) throws ServiceException;

    ResponseEntity<List<Partner>> findAll(Boolean technical) throws ServiceException;

    ResponseEntity<Partner> findByName(String name) throws ServiceException;

    ResponseEntity<Partner> getById(Long id) throws ServiceException;

    ResponseEntity<Partner> deleteById(Long id) throws ServiceException;

    ResponseEntity<Partner> update(Long id, Partner partner) throws ServiceException;

    ResponseEntity<List<Partner>> update(String name) throws ServiceException;

    ResponseEntity<PartnerContact> getContactById(Long id) throws ServiceException;

    ResponseEntity<Partner> updateContact(Long id, PartnerContact contact) throws ServiceException;

    ResponseEntity<Partner> deleteContact(Long id) throws ServiceException;
}