package hu.restoffice.employee.service;

import java.time.LocalDate;
import java.util.List;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.service.CRUDService;
import hu.restoffice.employee.entity.EmployeeShift;

/**
 *
 */
public interface EmployeeShiftService extends CRUDService<EmployeeShift> {


    /**
     * @param id
     * @return
     */
    List<EmployeeShift> findEmployeesUnstartedShifts(Long id);


    /**
     * @param entity
     * @return
     */
    boolean checkExistence(EmployeeShift entity);

    List<EmployeeShift> getScheduledShifts(LocalDate day) throws ServiceException;
}
