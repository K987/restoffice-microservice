package hu.restoffice.employee.controller;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.web.DefaultController;
import hu.restoffice.employee.converter.EmployeeConverterService;
import hu.restoffice.employee.domain.EmployeeStub;
import hu.restoffice.employee.service.EmployeeService;

/**
 *
 */
@RestController
@RequestMapping(path = "/employee", produces = MediaType.APPLICATION_JSON)
public class EmployeeControllerImpl implements EmployeeController {

    @Resource
    private DefaultController employeeDefaultController;

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
    public EmployeeConverterService getConverter() {
        return (EmployeeConverterService) employeeDefaultController.getConverter();
    }

    /**
     * @return
     * @see hu.restoffice.commons.web.DefaultController#getService()
     */
    public EmployeeService getService() {
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
            @RequestParam("from-date") @NotNull final LocalDate from,
            @RequestParam("to-date") @NotNull final LocalDate to)
                    throws ServiceException {
        // TODO: redirektelni a shift controller egy szolgáltatásához
        return null;
    }

}
