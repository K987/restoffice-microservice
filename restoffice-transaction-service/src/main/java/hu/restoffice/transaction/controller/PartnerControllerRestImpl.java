package hu.restoffice.transaction.controller;

import java.net.URI;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import hu.restoffice.transaction.entity.Partner;
import hu.restoffice.transaction.error.ServiceException;
import hu.restoffice.transaction.service.PartnerService;

/**
 *
 */
@RestController
@RequestMapping(path = "/partner", produces = MediaType.APPLICATION_JSON)
public class PartnerControllerRestImpl {

    @Autowired
    private PartnerService service;

    @GetMapping
    public ResponseEntity<List<Partner>> findAll() throws ServiceException {
        return ResponseEntity.ok(service.findAll(null));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<?> create(@RequestBody final Partner partner) throws ServiceException {
        Partner createdPartner = service.add(partner);
        return ResponseEntity.created(createPathTo(createdPartner.getId())).build();
    }

    @GetMapping(params = "technical")
    public ResponseEntity<List<Partner>> findAll(@RequestParam("technical") final Boolean technical)
            throws ServiceException {
        return ResponseEntity.ok(service.findAll(technical));
    }

    @GetMapping(params = "name")
    public ResponseEntity<Partner> findByName(@RequestParam("name") final String name) throws ServiceException {
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partner> getById(@PathVariable final Long id) throws ServiceException {
        return ResponseEntity.ok(service.findyById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Partner> deleteById(@PathVariable final Long id) throws ServiceException {
        return ResponseEntity.ok(service.delete(id));
    }

    @PostMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<Partner> update(@PathVariable("id") final Long id, @RequestBody final Partner partner)
            throws ServiceException {
        return ResponseEntity.ok(service.update(id, partner));
    }

    @GetMapping(path = "/search", params = "name")
    public ResponseEntity<List<Partner>> update(@RequestParam final String name)
            throws ServiceException {
        return ResponseEntity.ok(service.serachByName(name));
    }

    private URI createPathTo(final Long partnerId) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(partnerId).toUri();
    }

}
