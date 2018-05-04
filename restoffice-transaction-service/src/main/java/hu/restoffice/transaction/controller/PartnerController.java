package hu.restoffice.transaction.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.web.CRUDController;
import hu.restoffice.transaction.domain.PartnerStub;
import hu.restoffice.transaction.entity.PartnerContact;

/**
 *
 */
public interface PartnerController extends CRUDController<PartnerStub> {

    @DeleteMapping(path = "/{id}/contact")
    public ResponseEntity<PartnerStub> deleteContact(@PathVariable("id") final Long id) throws ServiceException;

    @PostMapping(path = "/{id}/contact", consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<PartnerStub> updateContact(@PathVariable("id") final Long id,
            @RequestBody @Validated final PartnerContact contact) throws ServiceException;
}
