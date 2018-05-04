package hu.restoffice.employee.controller;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.constraints.Digits;
import javax.ws.rs.core.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ResponseEntity<?> deleteResource(final Long id) throws ServiceException {
        return employeeDefaultController.deleteResource(id);
    }

    /**
     * @param id
     * @return
     * @throws ServiceException
     * @see hu.restoffice.commons.web.DefaultController#findResourceById(java.lang.Long)
     */
    @Override
    public ResponseEntity<?> findResourceById(final Long id) throws ServiceException {
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
    public ResponseEntity<?> addResource(final EmployeeStub arg0) throws ServiceException {
        return employeeDefaultController.addResource(arg0);
    }

    /*
     * (non-Javadoc)
     *
     * @see hu.restoffice.commons.web.CRUDController#updateResource(java.lang.Long,
     * java.lang.Object)
     */
    @Override
    public ResponseEntity<?> updateResource(@Digits(fraction = 0, integer = 10) final Long arg0,
            final EmployeeStub arg1) throws ServiceException {
        return employeeDefaultController.updateResource(arg0, arg1);
    }

    @Override
    public ResponseEntity<?> getEmployeeResourceScheduleBetweenDates(final Long empId, final LocalDate from,
            final LocalDate to)
            throws ServiceException {
        // TODO: redirektelni a shift controller egy szolgáltatásához
        return null;
    }

}
