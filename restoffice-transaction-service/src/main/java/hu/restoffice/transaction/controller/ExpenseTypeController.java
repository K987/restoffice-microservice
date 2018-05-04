package hu.restoffice.transaction.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.web.CRUDController;
import hu.restoffice.transaction.domain.ExpenseTypeStub;

/**
 *
 */
public interface ExpenseTypeController extends CRUDController<ExpenseTypeStub> {

    /**
     * @param name
     * @return
     * @throws ServiceException
     */
    @GetMapping(params = "name")
    ResponseEntity<ExpenseTypeStub> findByName(@RequestParam("name") String name) throws ServiceException;

    /**
     * @param prodRelated
     * @return
     * @throws ServiceException
     */
    @GetMapping(params = "prodRelated")
    ResponseEntity<List<ExpenseTypeStub>> findAll(@RequestParam("prodRelated") Boolean prodRelated)
            throws ServiceException;

}
