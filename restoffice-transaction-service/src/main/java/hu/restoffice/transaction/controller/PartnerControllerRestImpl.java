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
import hu.restoffice.transaction.entity.Partner;
import hu.restoffice.transaction.entity.PartnerContact;
import hu.restoffice.transaction.error.ServiceException;
import hu.restoffice.transaction.service.PartnerService;

/**
 *
 */
@RestController
@RequestMapping(path = "/partner", produces = MediaType.APPLICATION_JSON)
public class PartnerControllerRestImpl implements PartnerController {

    @Autowired
    private PartnerService service;

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.controller.PartnerController#findAll()
     */
    @Override
    @GetMapping
    public ResponseEntity<List<Partner>> findAll() throws ServiceException {
        return ResponseEntity.ok(service.findAll(null));
    }

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.controller.PartnerController#create(hu.restoffice.transaction.entity.Partner)
     */
    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<?> create(@RequestBody @Validated final Partner partner) throws ServiceException {
        Partner createdPartner = service.add(partner);
        return ResponseEntity.created(ControllerUtils.createPathTo(createdPartner.getId())).build();
    }

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.controller.PartnerController#findAll(java.lang.Boolean)
     */
    @Override
    @GetMapping(params = "technical")
    public ResponseEntity<List<Partner>> findAll(@RequestParam("technical") final Boolean technical)
            throws ServiceException {
        return ResponseEntity.ok(service.findAll(technical));
    }

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.controller.PartnerController#findByName(java.lang.String)
     */
    @Override
    @GetMapping(params = "name")
    public ResponseEntity<Partner> findByName(@RequestParam("name") final String name) throws ServiceException {
        return ResponseEntity.ok(service.findByName(name));
    }

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.controller.PartnerController#getById(java.lang.Long)
     */
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Partner> getById(@PathVariable final Long id) throws ServiceException {
        return ResponseEntity.ok(service.findById(id));
    }

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.controller.PartnerController#deleteById(java.lang.Long)
     */
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Partner> deleteById(@PathVariable final Long id) throws ServiceException {
        return ResponseEntity.ok(service.delete(id));
    }

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.controller.PartnerController#update(java.lang.Long, hu.restoffice.transaction.entity.Partner)
     */
    @Override
    @PostMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<Partner> update(@PathVariable("id") final Long id,
            @RequestBody @Validated final Partner partner)
                    throws ServiceException {
        return ResponseEntity.ok(service.update(id, partner));
    }

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.controller.PartnerController#update(java.lang.String)
     */
    @Override
    @GetMapping(path = "/search", params = "name")
    public ResponseEntity<List<Partner>> update(@RequestParam final String name)
            throws ServiceException {
        return ResponseEntity.ok(service.serachByName(name));
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.controller.PartnerController#getContactById(java.
     * lang.Long)
     */
    @Override
    @GetMapping(path = "{id}/contact")
    public ResponseEntity<PartnerContact> getContactById(@PathVariable("id") final Long id) throws ServiceException {
        return ResponseEntity.ok(service.getContact(id));
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.controller.PartnerController#updateContact(java.
     * lang.Long, hu.restoffice.transaction.entity.PartnerContact)
     */
    @Override
    @PostMapping(path = "{id}/contact", consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<Partner> updateContact(@PathVariable("id") final Long id,
            @RequestBody @Validated final PartnerContact contact)
                    throws ServiceException {
        return ResponseEntity.ok(service.updateContact(id, contact));
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.controller.PartnerController#deleteContact(java.
     * lang.Long)
     */
    @Override
    @DeleteMapping(path = "{id}/contact")
    public ResponseEntity<Partner> deleteContact(@PathVariable("id") final Long id) throws ServiceException {
        return ResponseEntity.ok(service.deleteContact(id));
    }

}
