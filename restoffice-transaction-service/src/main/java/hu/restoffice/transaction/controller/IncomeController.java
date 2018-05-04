package hu.restoffice.transaction.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.web.CRUDController;
import hu.restoffice.transaction.domain.IncomeStub;

/**
 *
 */
public interface IncomeController extends CRUDController<IncomeStub> {

    @GetMapping(path = "/{id}/partner")
    public ResponseEntity<IncomeStub> getPartner(@PathVariable("id") final Long id,
            @RequestHeader(HttpHeaders.AUTHORIZATION) final String authToken) throws ServiceException;
}
