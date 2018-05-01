package hu.restoffice.transaction.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import hu.restoffice.transaction.domain.PartnerStub;
import hu.restoffice.transaction.entity.PartnerContact;
import hu.restoffice.transaction.error.ServiceException;

/**
 *
 */
public interface PartnerController {

    ResponseEntity<List<PartnerStub>> findAll() throws ServiceException;

    ResponseEntity<?> create(PartnerStub partner) throws ServiceException;

    ResponseEntity<List<PartnerStub>> findAll(Boolean technical) throws ServiceException;

    ResponseEntity<PartnerStub> findByName(String name) throws ServiceException;

    ResponseEntity<PartnerStub> getById(Long id) throws ServiceException;

    ResponseEntity<PartnerStub> deleteById(Long id) throws ServiceException;

    ResponseEntity<PartnerStub> update(Long id, PartnerStub partner) throws ServiceException;

    ResponseEntity<List<PartnerStub>> update(String name) throws ServiceException;

    ResponseEntity<PartnerContact> getContactById(Long id) throws ServiceException;

    ResponseEntity<PartnerStub> updateContact(Long id, PartnerContact contact) throws ServiceException;

    ResponseEntity<PartnerStub> deleteContact(Long id) throws ServiceException;
}