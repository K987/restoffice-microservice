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

import hu.restoffice.commons.ControllerUtils;
import hu.restoffice.commons.ServiceException;
import hu.restoffice.transaction.converter.IncomeTypeConverterService;
import hu.restoffice.transaction.domain.IncomeTypeStub;
import hu.restoffice.transaction.entity.IncomeType;
import hu.restoffice.transaction.service.IncomeTypeService;

/**
 *
 */
@RestController
@RequestMapping(path = "/misc/income-type", produces = MediaType.APPLICATION_JSON)
public class IncomeTypeController {

    @Autowired
    private IncomeTypeService service;

    @Autowired
    private IncomeTypeConverterService converter;

    @GetMapping
    public ResponseEntity<List<IncomeTypeStub>> findAll() throws ServiceException {
        return ResponseEntity.ok(from(service.findAll()));
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<?> create(@RequestBody @Validated final IncomeTypeStub incomeType) throws ServiceException {
        IncomeType createdPartner = service.add(to(incomeType));
        return ResponseEntity.created(ControllerUtils.createPathTo(createdPartner.getId())).build();
    }

    @GetMapping(params = "prodRelated")
    public ResponseEntity<List<IncomeTypeStub>> findAll(@RequestParam("prodRelated") final Boolean prodRelated)
            throws ServiceException {
        return ResponseEntity.ok(from(service.findAll(prodRelated)));
    }

    @GetMapping(params = "name")
    public ResponseEntity<IncomeTypeStub> findByName(@RequestParam("name") final String name) throws ServiceException {
        return ResponseEntity.ok(from(service.findByName(name)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncomeTypeStub> getById(@PathVariable final Long id) throws ServiceException {
        return ResponseEntity.ok(from(service.findById(id)));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<IncomeTypeStub> deleteById(@PathVariable final Long id) throws ServiceException {
        return ResponseEntity.ok(from(service.delete(id)));
    }

    @PostMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<IncomeTypeStub> update(@PathVariable("id") final Long id,
            @RequestBody @Validated final IncomeTypeStub incomeType) throws ServiceException {
        return ResponseEntity.ok(from(service.update(id, to(incomeType))));
    }

    /**
     * @param entity
     * @return
     * @see hu.restoffice.commons.DefaultConverterService#from(java.lang.Object)
     */
    private IncomeTypeStub from(final IncomeType entity) {
        return converter.from(entity);
    }

    /**
     * @param stub
     * @return
     * @see hu.restoffice.commons.DefaultConverterService#to(java.lang.Object)
     */
    private IncomeType to(final IncomeTypeStub stub) {
        return converter.to(stub);
    }

    /**
     * @param entity
     * @return
     * @see hu.restoffice.commons.DefaultConverterService#from(java.util.List)
     */
    private List<IncomeTypeStub> from(final List<IncomeType> entity) {
        return converter.from(entity);
    }

    // /**
    // * @param stubs
    // * @return
    // * @see
    // hu.restoffice.transaction.converter.DefaultConverterService#to(java.util.List)
    // */
    // private List<IncomeType> to(final List<IncomeTypeStub> stubs) {
    // return converter.to(stubs);
    // }

}
