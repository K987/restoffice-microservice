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
import hu.restoffice.transaction.entity.IncomeType;
import hu.restoffice.transaction.error.ServiceException;
import hu.restoffice.transaction.service.IncomeTypeService;

/**
 *
 */
@RestController
@RequestMapping(path = "/misc/income-type", produces = MediaType.APPLICATION_JSON)
public class IncomeTypeController {

    @Autowired
    private IncomeTypeService service;


    @GetMapping
    public ResponseEntity<List<IncomeType>> findAll() throws ServiceException {
        return ResponseEntity.ok(service.findAll());
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<?> create(@RequestBody @Validated final IncomeType incomeType) throws ServiceException {
        IncomeType createdPartner = service.add(incomeType);
        return ResponseEntity.created(ControllerUtils.createPathTo(createdPartner.getId())).build();
    }

    @GetMapping(params = "prodRelated")
    public ResponseEntity<List<IncomeType>> findAll(@RequestParam("prodRelated") final Boolean prodRelated)
            throws ServiceException {
        return ResponseEntity.ok(service.findAll(prodRelated));
    }

    @GetMapping(params = "name")
    public ResponseEntity<IncomeType> findByName(@RequestParam("name") final String name) throws ServiceException {
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncomeType> getById(@PathVariable final Long id) throws ServiceException {
        return ResponseEntity.ok(service.findById(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<IncomeType> deleteById(@PathVariable final Long id) throws ServiceException {
        return ResponseEntity.ok(service.delete(id));
    }

    @PostMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<IncomeType> update(@PathVariable("id") final Long id,
            @RequestBody @Validated final IncomeType incomeType) throws ServiceException {
        return ResponseEntity.ok(service.update(id, incomeType));
    }
}
