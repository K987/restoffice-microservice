package hu.restoffice.employee.controller;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.MediaType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.web.DefaultController;
import hu.restoffice.employee.converter.ShiftConverterService;
import hu.restoffice.employee.domain.ShiftStub;
import hu.restoffice.employee.service.ShiftService;

/**
 *
 */
@RestController
@RequestMapping(path = "/shift", produces = MediaType.APPLICATION_JSON)
public class ShiftControllerImpl implements ShiftController {

    @Resource
    private DefaultController shiftDefaultController;

    /**
     * @param id
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#deleteResource(java.lang.Long)
     */
    @Override
    public ResponseEntity<?> deleteResource(@PathVariable("id") final Long id) throws ServiceException {
        return shiftDefaultController.deleteResource(id);
    }

    /**
     * @param id
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#findResourceById(java.lang.Long)
     */
    @Override
    public ResponseEntity<?> findResourceById(@PathVariable("id") final Long id) throws ServiceException {
        return shiftDefaultController.findResourceById(id);
    }

    /**
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#findallResource()
     */
    @Override
    public ResponseEntity<List<?>> findallResource() throws ServiceException {
        return shiftDefaultController.findallResource();
    }

    /**
     * @return
     * @see hu.restoffice.commons.web.DefaultController#getConverter()
     */
    public ShiftConverterService converter() {
        return (ShiftConverterService) shiftDefaultController.getConverter();
    }

    /**
     * @return
     * @see hu.restoffice.commons.web.DefaultController#getService()
     */
    public ShiftService service() {
        return (ShiftService) shiftDefaultController.getService();
    }

    /*
     * (non-Javadoc)
     *
     * @see hu.restoffice.commons.web.CRUDController#addResource(java.lang.Object)
     */
    @Override
    public ResponseEntity<?> addResource(@RequestBody final ShiftStub arg0) throws ServiceException {
        return shiftDefaultController.addResource(arg0);
    }

    /*
     * (non-Javadoc)
     *
     * @see hu.restoffice.commons.web.CRUDController#updateResource(java.lang.Long,
     * java.lang.Object)
     */
    @Override
    public ResponseEntity<?> updateResource(@PathVariable("id") @Digits(fraction = 0, integer = 10) final Long arg0,
            @RequestBody final ShiftStub arg1)
                    throws ServiceException {
        return shiftDefaultController.updateResource(arg0, arg1);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.employee.controller.ShiftController#getScheduleBetween(java.
     * time.LocalDate, java.time.LocalDate)
     */
    @Override
    public ResponseEntity<?> getScheduleBetween(
            @RequestParam("from-date") @NotNull @DateTimeFormat(iso = ISO.DATE) final LocalDate from,
            @RequestParam("to-date") @NotNull @DateTimeFormat(iso = ISO.DATE) final LocalDate to)
                    throws ServiceException {
        return ResponseEntity.ok(converter().from(service().getScheduleBetween(from, to)));
    }

}
