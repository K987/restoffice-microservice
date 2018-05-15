package hu.restoffice.employee.controller;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.web.CRUDController;
import hu.restoffice.employee.domain.EmployeeShiftStub;

/**
 *
 */
public interface EmployeeShiftController extends CRUDController<EmployeeShiftStub> {

    @GetMapping(params = { "day" })
    ResponseEntity<?> getEmployeeShiftsOfDay(
            @RequestParam("day") @NotNull @DateTimeFormat(iso = ISO.DATE) LocalDate day) throws ServiceException;
}
