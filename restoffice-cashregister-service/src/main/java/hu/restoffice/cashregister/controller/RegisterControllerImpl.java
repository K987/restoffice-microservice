package hu.restoffice.cashregister.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.constraints.Digits;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.restoffice.cashregister.converter.RegisterCloseConverterService;
import hu.restoffice.cashregister.domain.RegisterStub;
import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.web.DefaultController;

/**
 *
 */
@RestController
@ExposesResourceFor(RegisterStub.class)
@RequestMapping(path = "/register", produces = MediaType.APPLICATION_JSON)
public class RegisterControllerImpl implements RegisterController {

    @Resource
    private DefaultController registerDefaultController;

    @Autowired
    private RegisterCloseConverterService registerCloseConverter;

    @Autowired
    EntityLinks entityLinks;

    /**
     * @return
     * @throws ServiceException
     * @throws hu.restoffice.commons.ServiceException
     * @see hu.restoffice.commons.DefaultController#findallResource()
     */
    @Override
    public ResponseEntity<List<?>> findallResource() throws ServiceException {
        return registerDefaultController.findallResource();
    }

    /**
     * @param id
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.DefaultController#findResourceById(java.lang.Long)
     */
    @Override
    public ResponseEntity<?> findResourceById(@PathVariable("id") @Digits(fraction = 0, integer = 10) final Long id)
            throws ServiceException {
        return registerDefaultController.findResourceById(id);
    }

    /**
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.DefaultController#addResource(java.lang.Object)
     */
    @Override
    public ResponseEntity<?> addResource(final @RequestBody @Validated RegisterStub stub) throws ServiceException {
        return registerDefaultController.addResource(stub);
    }

    /**
     * @param id
     * @param stub
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.DefaultController#updateResource(java.lang.Long,
     *      java.lang.Object)
     */
    @Override
    public ResponseEntity<?> updateResource(@PathVariable("id") @Digits(fraction = 0, integer = 10) final Long id,
            @RequestBody @Validated final RegisterStub stub) throws ServiceException {
        return registerDefaultController.updateResource(id, stub);
    }

    /**
     * @param id
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.DefaultController#deleteResource(java.lang.Long)
     */
    @Override
    public ResponseEntity<?> deleteResource(@PathVariable("id") @Digits(fraction = 0, integer = 10) final Long id)
            throws ServiceException {
        return registerDefaultController.deleteResource(id);
    }
}
