package hu.restoffice.transaction.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.restoffice.transaction.controller.util.ControllerUtils;
import hu.restoffice.transaction.entity.ExpenseType;
import hu.restoffice.transaction.error.ServiceException;
import hu.restoffice.transaction.service.ExpenseTypeService;

/**
 *
 */
@RestController
@RequestMapping(path = "/misc/expense-type", produces = MediaType.APPLICATION_JSON)
public class ExpenseTypeController {

    @Autowired
    private ExpenseTypeService service;


    @GetMapping
    public ResponseEntity<List<ExpenseType>> findAll() throws ServiceException {
        return ResponseEntity.ok(service.findAll());
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<?> create(@RequestBody @Validated final ExpenseType expenseType) throws ServiceException {
        ExpenseType createdPartner = service.add(expenseType);
        return ResponseEntity.created(ControllerUtils.createPathTo(createdPartner.getId())).build();
    }

    @GetMapping(params = "prodRelated")
    public ResponseEntity<List<ExpenseType>> findAll(@RequestParam("prodRelated") final Boolean prodRelated)
            throws ServiceException {
        return ResponseEntity.ok(service.findAll(prodRelated));
    }

    @GetMapping(params = "name")
    public ResponseEntity<ExpenseType> findByName(@RequestParam("name") final String name) throws ServiceException {
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseType> getById(@PathVariable final Long id) throws ServiceException {
        return ResponseEntity.ok(service.findById(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ExpenseType> deleteById(@PathVariable final Long id) throws ServiceException {
        return ResponseEntity.ok(service.delete(id));
    }

    @PostMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<ExpenseType> update(@PathVariable("id") final Long id,
            @RequestBody @Validated final ExpenseType expenseType) throws ServiceException {
        return ResponseEntity.ok(service.update(id, expenseType));
    }
}
