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
import hu.restoffice.transaction.converter.ExpenseTypeConverterService;
import hu.restoffice.transaction.domain.ExpenseTypeStub;
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

    @Autowired
    private ExpenseTypeConverterService converter;

    @GetMapping
    public ResponseEntity<List<ExpenseTypeStub>> findAll() throws ServiceException {
        return ResponseEntity.ok(converter.from(service.findAll()));
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<?> create(@RequestBody @Validated final ExpenseTypeStub expenseType) throws ServiceException {
        ExpenseType createdPartner = service.add(converter.to(expenseType));
        return ResponseEntity.created(ControllerUtils.createPathTo(createdPartner.getId())).build();
    }

    @GetMapping(params = "prodRelated")
    public ResponseEntity<List<ExpenseTypeStub>> findAll(@RequestParam("prodRelated") final Boolean prodRelated)
            throws ServiceException {
        return ResponseEntity.ok(converter.from(service.findAll(prodRelated)));
    }

    @GetMapping(params = "name")
    public ResponseEntity<ExpenseTypeStub> findByName(@RequestParam("name") final String name) throws ServiceException {
        return ResponseEntity.ok(converter.from(service.findByName(name)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseTypeStub> getById(@PathVariable final Long id) throws ServiceException {
        return ResponseEntity.ok(converter.from(service.findById(id)));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ExpenseTypeStub> deleteById(@PathVariable final Long id) throws ServiceException {
        return ResponseEntity.ok(converter.from(service.delete(id)));
    }

    @PostMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<ExpenseTypeStub> update(@PathVariable("id") final Long id,
            @RequestBody @Validated final ExpenseTypeStub expenseType) throws ServiceException {
        return ResponseEntity.ok(converter.from(service.update(id, converter.to(expenseType))));
    }

}
