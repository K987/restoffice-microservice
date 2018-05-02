package hu.restoffice.cashregister.controller;

import javax.annotation.Resource;
import javax.validation.constraints.Digits;
import javax.ws.rs.core.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.restoffice.cashregister.domain.RegisterStub;
import hu.restoffice.commons.DefaultController;
import hu.restoffice.commons.ServiceException;

/**
 *
 */
@RestController
@RequestMapping(path = "/register", produces = MediaType.APPLICATION_JSON)
public class RegisterRestController {

    @Resource
    private DefaultController registerControllerDefault;

    /**
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.DefaultController#findallResource()
     */
    @GetMapping
    public ResponseEntity<?> findallResource() throws ServiceException {
        return registerControllerDefault.findallResource();
    }

    /**
     * @param id
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.DefaultController#findResourceById(java.lang.Long)
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> findResourceById(@PathVariable("id") @Digits(fraction = 0, integer = 10) final Long id)
            throws ServiceException {
        return registerControllerDefault.findResourceById(id);
    }

    /**
     * @param stub
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.DefaultController#addResource(java.lang.Object)
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<?> addResource(final @RequestBody @Validated RegisterStub stub) throws ServiceException {
        return registerControllerDefault.addResource(stub);
    }

    /**
     * @param id
     * @param stub
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.DefaultController#updateResource(java.lang.Long,
     *      java.lang.Object)
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON, path = "/{id}")
    public ResponseEntity<?> updateResource(@PathVariable("id") @Digits(fraction = 0, integer = 10) final Long id,
            @RequestBody @Validated final RegisterStub stub) throws ServiceException {
        return registerControllerDefault.updateResource(id, stub);
    }

    /**
     * @param id
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.DefaultController#deleteResource(java.lang.Long)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteResource(@PathVariable("id") @Digits(fraction = 0, integer = 10) final Long id)
            throws ServiceException {
        return registerControllerDefault.deleteResource(id);
    }

}
