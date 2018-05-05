package hu.restoffice.employee.service;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.service.CRUDService;
import hu.restoffice.employee.entity.Employee;

/**
 *
 */
public interface EmployeeService extends CRUDService<Employee> {

    /**
     * @param empId
     * @param shiftId
     * @throws ServiceException
     */
    Long addEmployeToShift(Long empId, Long shiftId) throws ServiceException;

}
