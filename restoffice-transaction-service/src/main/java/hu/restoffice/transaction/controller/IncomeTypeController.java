package hu.restoffice.transaction.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.web.CRUDController;
import hu.restoffice.transaction.domain.IncomeTypeStub;

/**
 *
 */
public interface IncomeTypeController extends CRUDController<IncomeTypeStub> {

    @GetMapping(params = "prodRelated")
    public ResponseEntity<List<IncomeTypeStub>> findAll(@RequestParam("prodRelated") final Boolean prodRelated)
            throws ServiceException;

    @GetMapping(params = "name")
    public ResponseEntity<IncomeTypeStub> findByName(@RequestParam("name") final String name) throws ServiceException;
}
