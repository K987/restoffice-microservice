package hu.restoffice.employee.controller;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.web.CRUDController;
import hu.restoffice.employee.domain.EmployeeStub;

/**
 *
 */
public interface EmployeeController extends CRUDController<EmployeeStub> {

    /**
     * @param empId
     * @param from
     * @param to
     * @return
     * @throws ServiceException
     */
    @GetMapping(path = "/{id}/shift", params = { "from-date", "to-date" })
    ResponseEntity<?> getEmployeeResourceScheduleBetweenDates(@PathVariable("id") Long empId,
            @RequestParam("from-date") @NotNull @DateTimeFormat(iso = ISO.DATE) LocalDate from,
            @RequestParam("to-date") @NotNull @DateTimeFormat(iso = ISO.DATE) LocalDate to) throws ServiceException;

    @PostMapping(path = "/{empId}/shift/{shiftId}")
    ResponseEntity<?> addEmployeeToShift(@PathVariable("empId") Long empId, @PathVariable("shiftId") Long shiftId)
            throws ServiceException;

}
