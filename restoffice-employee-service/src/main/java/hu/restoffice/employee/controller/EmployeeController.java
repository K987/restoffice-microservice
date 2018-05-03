package hu.restoffice.employee.controller;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping(path = "/{id}", params = { "from-date, to-date" })
    ResponseEntity<?> getSchedule(@PathVariable("id") Long empId, @RequestParam("from-date") @NotNull LocalDate from,
            @RequestParam("to-date") @NotNull LocalDate to) throws ServiceException;

}
