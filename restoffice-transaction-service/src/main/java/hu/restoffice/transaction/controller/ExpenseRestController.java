package hu.restoffice.transaction.controller;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import hu.restoffice.transaction.controller.util.ControllerUtils;
import hu.restoffice.transaction.converter.ExpenseConverterService;
import hu.restoffice.transaction.domain.ExpenseStub;
import hu.restoffice.transaction.entity.Expense;
import hu.restoffice.transaction.error.ServiceException;
import hu.restoffice.transaction.service.ExpenseService;

/**
 *
 */
@RestController
@RequestMapping(path = "/expense", produces = MediaType.APPLICATION_JSON)
public class ExpenseRestController {

    @Autowired
    private ExpenseService service;

    @Autowired
    private ExpenseConverterService converter;


    @GetMapping
    public ResponseEntity<List<ExpenseStub>> findAll() throws ServiceException {
        return ResponseEntity.ok(converter.from(service.findAll()));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<?> create(@RequestBody @Validated final ExpenseStub expense) throws ServiceException {
        Expense createdPartner = service.add(converter.to(expense));
        return ResponseEntity.created(ControllerUtils.createPathTo(createdPartner.getId())).build();
    }

    @GetMapping(params = "docId")
    public ResponseEntity<ExpenseStub> getById(@RequestParam("docId") final @NotBlank String docId)
            throws ServiceException {
        return ResponseEntity.ok(converter.from(service.findyByDocId(docId)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseStub> getById(@PathVariable final Long id) throws ServiceException {
        return ResponseEntity.ok(converter.from(service.findById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ExpenseStub> deleteById(@PathVariable final Long id) throws ServiceException {
        return ResponseEntity.ok(converter.from(service.delete(id)));
    }

    @PostMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<ExpenseStub> update(@PathVariable("id") final Long id,
            @RequestBody @Validated final ExpenseStub expense) throws ServiceException {
        return ResponseEntity.ok(converter.from(service.update(id, converter.to(expense))));
    }

    @GetMapping(path = "/{id}/partner")
    public ResponseEntity<ExpenseStub> getPartner(@PathVariable("id") final Long id,
            @RequestHeader(HttpHeaders.AUTHORIZATION) final String authToken) throws ServiceException {
        Long partnerId = service.findById(id).getParty().getId();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(
                ServletUriComponentsBuilder.fromCurrentContextPath().path("/partner/{id}").buildAndExpand(partnerId)
                .toUri());
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).headers(headers).build();
    }

}
