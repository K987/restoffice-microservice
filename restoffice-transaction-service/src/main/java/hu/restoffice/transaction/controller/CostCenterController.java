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
import hu.restoffice.transaction.entity.CostCenter;
import hu.restoffice.transaction.error.ServiceException;
import hu.restoffice.transaction.service.CostCenterService;

/**
 *
 */
@RestController
@RequestMapping(path = "/misc/cost-center", produces = MediaType.APPLICATION_JSON)
public class CostCenterController {

    @Autowired
    private CostCenterService service;

    @GetMapping
    public ResponseEntity<List<CostCenter>> findAll() throws ServiceException {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<?> create(@RequestBody @Validated final CostCenter costCenter) throws ServiceException {
        CostCenter createdPartner = service.add(costCenter);
        return ResponseEntity.created(ControllerUtils.createPathTo(createdPartner.getId())).build();
    }

    @GetMapping("/default")
    public ResponseEntity<CostCenter> findDefault()
            throws ServiceException {
        return ResponseEntity.ok(service.getDefault());
    }

    @GetMapping(params = "name")
    public ResponseEntity<CostCenter> findByName(@RequestParam("name") final String name) throws ServiceException {
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CostCenter> getById(@PathVariable final Long id) throws ServiceException {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CostCenter> deleteById(@PathVariable final Long id) throws ServiceException {
        return ResponseEntity.ok(service.delete(id));
    }

    @PostMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<CostCenter> update(@PathVariable("id") final Long id,
            @RequestBody @Validated final CostCenter costCenter) throws ServiceException {
        return ResponseEntity.ok(service.update(id, costCenter));
    }

}
