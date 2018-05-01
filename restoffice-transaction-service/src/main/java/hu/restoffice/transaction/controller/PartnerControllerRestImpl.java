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
import hu.restoffice.transaction.converter.PartnerConverterService;
import hu.restoffice.transaction.domain.PartnerStub;
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

    @Autowired
    private PartnerConverterService converter;

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.controller.PartnerController#findAll()
     */
    @Override
    @GetMapping
    public ResponseEntity<List<PartnerStub>> findAll() throws ServiceException {
        return ResponseEntity.ok(from(service.findAll(null)));
    }

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.controller.PartnerController#create(hu.restoffice.transaction.entity.Partner)
     */
    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<?> create(@RequestBody @Validated final PartnerStub partner) throws ServiceException {
        Partner createdPartner = service.add(to(partner));
        return ResponseEntity.created(ControllerUtils.createPathTo(createdPartner.getId())).build();
    }

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.controller.PartnerController#findAll(java.lang.Boolean)
     */
    @Override
    @GetMapping(params = "technical")
    public ResponseEntity<List<PartnerStub>> findAll(@RequestParam("technical") final Boolean technical)
            throws ServiceException {
        return ResponseEntity.ok(from(service.findAll(technical)));
    }

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.controller.PartnerController#findByName(java.lang.String)
     */
    @Override
    @GetMapping(params = "name")
    public ResponseEntity<PartnerStub> findByName(@RequestParam("name") final String name) throws ServiceException {
        return ResponseEntity.ok(from(service.findByName(name)));
    }

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.controller.PartnerController#getById(java.lang.Long)
     */
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<PartnerStub> getById(@PathVariable final Long id) throws ServiceException {
        return ResponseEntity.ok(from(service.findById(id)));
    }

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.controller.PartnerController#deleteById(java.lang.Long)
     */
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<PartnerStub> deleteById(@PathVariable final Long id) throws ServiceException {
        return ResponseEntity.ok(from(service.delete(id)));
    }

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.controller.PartnerController#update(java.lang.Long, hu.restoffice.transaction.entity.Partner)
     */
    @Override
    @PostMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<PartnerStub> update(@PathVariable("id") final Long id,
            @RequestBody @Validated final PartnerStub partner)
                    throws ServiceException {
        return ResponseEntity.ok(from(service.update(id, to(partner))));
    }

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.controller.PartnerController#update(java.lang.String)
     */
    @Override
    @GetMapping(path = "/search", params = "name")
    public ResponseEntity<List<PartnerStub>> update(@RequestParam final String name)
            throws ServiceException {
        return ResponseEntity.ok(from(service.serachByName(name)));
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
    public ResponseEntity<PartnerStub> updateContact(@PathVariable("id") final Long id,
            @RequestBody @Validated final PartnerContact contact)
                    throws ServiceException {
        return ResponseEntity.ok(from(service.updateContact(id, contact)));
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
    public ResponseEntity<PartnerStub> deleteContact(@PathVariable("id") final Long id) throws ServiceException {
        return ResponseEntity.ok(from(service.deleteContact(id)));
    }

    /**
     * @param entity
     * @return
     * @see hu.restoffice.transaction.converter.DefaultConverterService#from(java.lang.Object)
     */
    public PartnerStub from(final Partner entity) {
        return converter.from(entity);
    }

    /**
     * @param stub
     * @return
     * @see hu.restoffice.transaction.converter.DefaultConverterService#to(java.lang.Object)
     */
    public Partner to(final PartnerStub stub) {
        return converter.to(stub);
    }

    /**
     * @param entity
     * @return
     * @see hu.restoffice.transaction.converter.DefaultConverterService#from(java.util.List)
     */
    public List<PartnerStub> from(final List<Partner> entity) {
        return converter.from(entity);
    }

    /**
     * @param stubs
     * @return
     * @see hu.restoffice.transaction.converter.DefaultConverterService#to(java.util.List)
     */
    public List<Partner> to(final List<PartnerStub> stubs) {
        return converter.to(stubs);
    }

}
