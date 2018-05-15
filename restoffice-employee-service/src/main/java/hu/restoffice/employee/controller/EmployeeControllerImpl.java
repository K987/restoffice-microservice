package hu.restoffice.employee.controller;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.web.DefaultController;
import hu.restoffice.employee.converter.EmployeeConverterService;
import hu.restoffice.employee.converter.ShiftConverterService;
import hu.restoffice.employee.domain.EmployeeStub;
import hu.restoffice.employee.entity.Shift;
import hu.restoffice.employee.service.EmployeeService;
import hu.restoffice.employee.service.ShiftService;

/**
 *
 */
@RestController
@RequestMapping(path = "/employee", produces = MediaType.APPLICATION_JSON)
public class EmployeeControllerImpl implements EmployeeController {

    @Resource
    private DefaultController employeeDefaultController;

    @Autowired
    private ShiftService shiftService;

    @Autowired
    private ShiftConverterService shiftConverterService;

    /**
     * @param id
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#deleteResource(java.lang.Long)
     */
    @Override
    public ResponseEntity<?> deleteResource(@PathVariable("id") final Long id) throws ServiceException {
        return employeeDefaultController.deleteResource(id);
    }

    /**
     * @param id
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#findResourceById(java.lang.Long)
     */
    @Override
    public ResponseEntity<?> findResourceById(@PathVariable("id") final Long id) throws ServiceException {
        return employeeDefaultController.findResourceById(id);
    }

    /**
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#findallResource()
     */
    @Override
    public ResponseEntity<List<?>> findallResource() throws ServiceException {
        return employeeDefaultController.findallResource();
    }

    /**
     * @return
     * @see hu.restoffice.commons.web.DefaultController#getConverter()
     */
    public EmployeeConverterService converter() {
        return (EmployeeConverterService) employeeDefaultController.getConverter();
    }

    /**
     * @return
     * @see hu.restoffice.commons.web.DefaultController#getService()
     */
    public EmployeeService service() {
        return (EmployeeService) employeeDefaultController.getService();
    }

    /*
     * (non-Javadoc)
     *
     * @see hu.restoffice.commons.web.CRUDController#addResource(java.lang.Object)
     */
    @Override
    public ResponseEntity<?> addResource(@RequestBody final EmployeeStub arg0) throws ServiceException {
        return employeeDefaultController.addResource(arg0);
    }

    /*
     * (non-Javadoc)
     *
     * @see hu.restoffice.commons.web.CRUDController#updateResource(java.lang.Long,
     * java.lang.Object)
     */
    @Override
    public ResponseEntity<?> updateResource(@PathVariable("id") @Digits(fraction = 0, integer = 10) final Long arg0,
            @RequestBody final EmployeeStub arg1) throws ServiceException {
        return employeeDefaultController.updateResource(arg0, arg1);
    }

    @Override
    public ResponseEntity<?> getEmployeeResourceScheduleBetweenDates(@PathVariable("id") final Long empId,
            @RequestParam("from-date") @NotNull @DateTimeFormat(iso = ISO.DATE) final LocalDate from,
            @RequestParam("to-date") @NotNull @DateTimeFormat(iso = ISO.DATE) final LocalDate to)
                    throws ServiceException {
        List<Shift> shifts = shiftService.getEmployeeScheduleBetween(empId, from, to);
        shifts.sort((o1, o2) -> o1.getStartDate().compareTo(o2.getStartDate()));
        return ResponseEntity.ok(shiftConverterService.from(shifts));

    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.employee.controller.EmployeeController#addEmployeeToShift(java.
     * lang.Long, java.lang.Long)
     */
    @Override
    public ResponseEntity<?> addEmployeeToShift(@PathVariable("empId") final Long empId,
            @PathVariable("shiftId") final Long shiftId) throws ServiceException {
        Long id = service().addEmployeToShift(empId, shiftId);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentContextPath().path("/employee-shift/{id}")
                .buildAndExpand(id).toUri()).build();

    }

}
