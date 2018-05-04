package hu.restoffice.cashregister.controller;

import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.restoffice.cashregister.converter.RegisterCloseConverterService;
import hu.restoffice.cashregister.domain.RegisterCloseStub;
import hu.restoffice.cashregister.domain.RegisterStub;
import hu.restoffice.cashregister.entity.RegisterClose;
import hu.restoffice.cashregister.service.RegisterCloseService;
import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.error.ServiceException.Type;
import hu.restoffice.commons.web.DefaultController;

/**
 *
 */
@RestController
@ExposesResourceFor(RegisterCloseStub.class)
@RequestMapping(path = "/register-close", produces = MediaType.APPLICATION_JSON)
public class RegisterCloseControllerImpl implements RegisterCloseController {
    // TODO: batch register close
    @Resource
    private DefaultController registerCloseDefaultController;

    @Autowired
    EntityLinks entityLinks;

    private RegisterCloseService service() {
        return (RegisterCloseService) registerCloseDefaultController.getService();
    }

    private RegisterCloseConverterService converter() {
        return (RegisterCloseConverterService) registerCloseDefaultController.getConverter();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.cashregister.controller.DefaultController#findallResource()
     */
    @SuppressWarnings("unchecked")
    @Override
    public ResponseEntity<List<?>> findallResource() throws ServiceException {
        ResponseEntity<List<?>> resp = registerCloseDefaultController.findallResource();
        List<RegisterCloseStub> stubs = (List<RegisterCloseStub>) resp.getBody();
        for (RegisterCloseStub body : stubs)
            body.add(entityLinks.linkToSingleResource(RegisterStub.class, body.getRegisterId()).withRel("register"));
        return resp;
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
        ResponseEntity<Object> resp = registerCloseDefaultController.findResourceById(id);
        RegisterCloseStub stub = (RegisterCloseStub) resp.getBody();
        stub.add(entityLinks.linkToSingleResource(RegisterStub.class, stub.getRegisterId()).withRel("register"));
        return resp;
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

    /*
     * (non-Javadoc)
     *
     * @see hu.restoffice.cashregister.controller.RegisterCloseController#
     * findResourceByDate(java.time.LocalDate, java.time.LocalDate)
     */
    @Override
    public ResponseEntity<List<?>> findResourceByDate(@RequestParam("fromDate") final LocalDate from,
            @RequestParam("toDate") final LocalDate to)
                    throws ServiceException {
        List<RegisterClose> rtrn;
        if (to != null)
            rtrn = service().getClosesByDate(from);
        else
            rtrn = service().getClosesBetweenDate(from, to);
        if (rtrn == null)
            throw new ServiceException(Type.NOT_EXISTS, "no closes between " + from + " and " + to);
        else
            return ResponseEntity.ok(converter().from(rtrn));
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.cashregister.controller.RegisterCloseController#getLastCloses()
     */
    @Override
    public ResponseEntity<List<?>> getLastCloses() throws ServiceException {
        // Visszakéne adni azokat a gépeket is amik még sose voltak zárva
        return ResponseEntity.ok(converter().from(service().getLastCloses()));
    }

}
