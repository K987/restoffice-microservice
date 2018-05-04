package hu.restoffice.transaction.controller;

import javax.validation.constraints.NotBlank;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.web.CRUDController;
import hu.restoffice.transaction.domain.ExpenseStub;

/**
 *
 */
public interface ExpenseController extends CRUDController<ExpenseStub> {

    /**
     * @param id
     * @param authToken
     * @return
     * @throws ServiceException
     */
    @GetMapping(path = "/{id}/partner")
    ResponseEntity<ExpenseStub> getPartner(@PathVariable("id") final Long id,
            @RequestHeader(HttpHeaders.AUTHORIZATION) final String authToken) throws ServiceException;

    /**
     * @param docId
     * @return
     * @throws ServiceException
     */
    @GetMapping(params = "docId")
    ResponseEntity<ExpenseStub> getById(@RequestParam("docId") @NotBlank String docId) throws ServiceException;

}
