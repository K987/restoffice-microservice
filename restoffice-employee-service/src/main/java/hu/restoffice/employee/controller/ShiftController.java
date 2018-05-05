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
import hu.restoffice.employee.domain.ShiftStub;

/**
 *
 */
public interface ShiftController extends CRUDController<ShiftStub> {

    /**
     * @param empId
     * @param from
     * @param to
     * @return
     * @throws ServiceException
     */
    @GetMapping(params = { "from-date", "to-date" })
    ResponseEntity<?> getScheduleBetween(
            @RequestParam("from-date") @NotNull @DateTimeFormat(iso = ISO.DATE) LocalDate from,
            @RequestParam("to-date") @NotNull @DateTimeFormat(iso = ISO.DATE) LocalDate to) throws ServiceException;

}
