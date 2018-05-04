package hu.restoffice.employee.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.constraints.Digits;
import javax.ws.rs.core.MediaType;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.web.DefaultController;
import hu.restoffice.employee.converter.EmployeeShiftConverterService;
import hu.restoffice.employee.domain.EmployeeShiftStub;
import hu.restoffice.employee.entity.EmployeeShift;
import hu.restoffice.employee.service.EmployeeShiftService;

/**
 *
 */
@RestController
@RequestMapping(path = "/employee/shift", produces = MediaType.APPLICATION_JSON)
public class EmployeeShiftControllerImpl implements EmployeeShiftController {

    @Resource
    private DefaultController employeeShiftDefaultController;

    /**
     * @param id
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#deleteResource(java.lang.Long)
     */
    @Override
    public ResponseEntity<?> deleteResource(@PathVariable("id") final Long id) throws ServiceException {
        return employeeShiftDefaultController.deleteResource(id);
    }

    /**
     * @param id
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#findResourceById(java.lang.Long)
     */
    @Override
    public ResponseEntity<?> findResourceById(@PathVariable("id") final Long id) throws ServiceException {
        return employeeShiftDefaultController.findResourceById(id);
    }

    /**
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#findallResource()
     */
    @Override
    public ResponseEntity<List<?>> findallResource() throws ServiceException {
        return employeeShiftDefaultController.findallResource();
    }

    /**
     * @return
     * @see hu.restoffice.commons.web.DefaultController#getConverter()
     */
    public EmployeeShiftConverterService converter() {
        return (EmployeeShiftConverterService) employeeShiftDefaultController.getConverter();
    }

    /**
     * @return
     * @see hu.restoffice.commons.web.DefaultController#getService()
     */
    public EmployeeShiftService service() {
        return (EmployeeShiftService) employeeShiftDefaultController.getService();
    }

    /*
     * (non-Javadoc)
     *
     * @see hu.restoffice.commons.web.CRUDController#addResource(java.lang.Object)
     */
    @Override
    public ResponseEntity<?> addResource(@RequestBody final EmployeeShiftStub arg0) throws ServiceException {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(
                "{\"message\" : \"this operation is not supported\", \"description\": \"try this: POST: /{employeeId}/{ShiftId} \"}");
    }

    /*
     * (non-Javadoc)
     *
     * @see hu.restoffice.commons.web.CRUDController#updateResource(java.lang.Long,
     * java.lang.Object)
     */
    @Override
    public ResponseEntity<?> updateResource(@PathVariable("id") @Digits(fraction = 0, integer = 10) final Long arg0,
            @RequestBody final EmployeeShiftStub arg1) throws ServiceException {
        return employeeShiftDefaultController.updateResource(arg0, arg1);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.employee.controller.EmployeeShiftController#add(java.lang.Long,
     * java.lang.Long, hu.restoffice.employee.entity.EmployeeShift)
     */
    @Override
    public ResponseEntity<EmployeeShiftStub> add(@PathVariable("employeeId") final Long empId,
            @PathVariable("shiftId") final Long shiftId, @RequestBody final EmployeeShift body)
                    throws ServiceException {
        return ResponseEntity.ok(converter().from(service().add(body, empId, shiftId)));
    }

}
