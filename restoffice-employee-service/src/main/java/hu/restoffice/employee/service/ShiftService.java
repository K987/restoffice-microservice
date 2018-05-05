package hu.restoffice.employee.service;

import java.time.LocalDate;
import java.util.List;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.service.CRUDService;
import hu.restoffice.employee.entity.Shift;

/**
 *
 */
public interface ShiftService extends CRUDService<Shift> {

    /**
     * @param empId
     * @param from
     * @param to
     * @return
     * @throws ServiceException
     */
    List<Shift> getEmployeeScheduleBetween(Long empId, LocalDate from, LocalDate to) throws ServiceException;

    List<Shift> getScheduleBetween(LocalDate from, LocalDate to) throws ServiceException;
}
