package hu.restoffice.transaction.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.web.DefaultController;
import hu.restoffice.transaction.converter.PartnerConverterService;
import hu.restoffice.transaction.domain.PartnerStub;
import hu.restoffice.transaction.entity.PartnerContact;
import hu.restoffice.transaction.service.PartnerService;

/**
 *
 */
@RestController
@RequestMapping(path = "/partner", produces = MediaType.APPLICATION_JSON)
public class PartnerControllerImpl implements PartnerController {

    private Logger log = LogManager.getLogger();

    @Autowired
    private DefaultController partnerControllerDefault;

    /**
     * @param stub
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#addResource(java.lang.Object)
     */
    @Override
    public ResponseEntity<?> addResource(final @RequestBody PartnerStub stub) throws ServiceException {
        return partnerControllerDefault.addResource(stub);
    }

    /**
     * @param id
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#deleteResource(java.lang.Long)
     */
    @Override
    public ResponseEntity<Object> deleteResource(final @PathVariable("id") Long id) throws ServiceException {
        return partnerControllerDefault.deleteResource(id);
    }

    /**
     * @param id
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#findResourceById(java.lang.Long)
     */
    @Override
    public ResponseEntity<Object> findResourceById(final @PathVariable("id") Long id) throws ServiceException {
        log.info("fin by if invoked in conrtoller id: " + id);
        return partnerControllerDefault.findResourceById(id);
    }

    /**
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#findallResource()
     */
    @Override
    public ResponseEntity<List<?>> findallResource() throws ServiceException {
        return partnerControllerDefault.findallResource();
    }

    /**
     * @return
     * @see hu.restoffice.commons.web.DefaultController#getConverter()
     */
    public PartnerConverterService converter() {
        return (PartnerConverterService) partnerControllerDefault.getConverter();
    }

    /**
     * @return
     * @see hu.restoffice.commons.web.DefaultController#getService()
     */
    public PartnerService service() {
        return (PartnerService) partnerControllerDefault.getService();
    }

    /**
     * @param id
     * @param stub
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#updateResource(java.lang.Long,
     *      java.lang.Object)
     */
    @Override
    public ResponseEntity<Object> updateResource(@PathVariable("id") final Long id,
            @ReesuestBody final final PartnerStub stub) throws ServiceException {
        return partnerControllerDefault.updateResource(id, stub);
    }

    /*
     * (non-Javadoc)
     *
     * @see hu.restoffice.transaction.controller.PartnerController#update(java.lang.
     * String)
     */
    @GetMapping(path = "/search", params = "name")
    public ResponseEntity<List<PartnerStub>> update(@RequestParam("name") final String name) throws ServiceException {
        return ResponseEntity.ok(converter().from(service().serachByName(name)));
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.controller.PartnerController#updateContact(java.
     * lang.Long, hu.restoffice.transaction.entity.PartnerContact)
     */
    @Override
    public ResponseEntity<PartnerStub> updateContact(@PathVariable("id") final Long id,
            @RequestBody @Validated final PartnerContact contact) throws ServiceException {
        return ResponseEntity.ok(converter().from(service().updateContact(id, contact)));
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.controller.PartnerController#deleteContact(java.
     * lang.Long)
     */
    @Override
    public ResponseEntity<PartnerStub> deleteContact(@PathVariable("id") final Long id) throws ServiceException {
        return ResponseEntity.ok(converter().from(service().deleteContact(id)));
    }

}
