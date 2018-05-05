package hu.restoffice.employee.service;

import java.util.List;

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

}
