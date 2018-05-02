package hu.restoffice.cashregister.controller;

import javax.annotation.Resource;
import javax.validation.constraints.Digits;
import javax.ws.rs.core.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.restoffice.cashregister.domain.RegisterCloseStub;
import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.web.DefaultController;

/**
 *
 */
@RestController
@RequestMapping(path = "/register-close", produces = MediaType.APPLICATION_JSON)
public class RgisterCloseControllerImpl implements RegisterCloseController {

    @Resource
    private DefaultController registerCloseDefaultController;

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.cashregister.controller.DefaultController#findallResource()
     */
    @Override
    public ResponseEntity<?> findallResource() throws ServiceException {
        // TODO Auto-generated method stub
        return registerCloseDefaultController.findallResource();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.cashregister.controller.DefaultController#findResourceById(java
     * .lang.Long)
     */
    @Override
    public ResponseEntity<?> findResourceById(final @PathVariable("id") @Digits(fraction = 0, integer = 10) Long id)
            throws ServiceException {
        // TODO Auto-generated method stub
        return registerCloseDefaultController.findResourceById(id);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.cashregister.controller.DefaultController#addResource(java.lang
     * .Object)
     */
    @Override
    public ResponseEntity<?> addResource(final @RequestBody @Validated RegisterCloseStub stub) throws ServiceException {
        // TODO Auto-generated method stub
        return registerCloseDefaultController.addResource(stub);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.cashregister.controller.DefaultController#updateResource(java.
     * lang.Long, java.lang.Object)
     */
    @Override
    public ResponseEntity<?> updateResource(final @PathVariable("id") @Digits(fraction = 0, integer = 10) Long id,
            @RequestBody @Validated final RegisterCloseStub stub) throws ServiceException {
        return registerCloseDefaultController.updateResource(id, stub);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.cashregister.controller.DefaultController#deleteResource(java.
     * lang.Long)
     */
    @Override
    public ResponseEntity<?> deleteResource(final @PathVariable("id") @Digits(fraction = 0, integer = 10) Long id)
            throws ServiceException {
        return registerCloseDefaultController.deleteResource(id);
    }


}
