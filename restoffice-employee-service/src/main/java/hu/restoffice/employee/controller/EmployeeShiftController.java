package hu.restoffice.employee.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.web.CRUDController;
import hu.restoffice.employee.domain.EmployeeShiftStub;
import hu.restoffice.employee.entity.EmployeeShift;

/**
 *
 */
public interface EmployeeShiftController extends CRUDController<EmployeeShiftStub> {

    // TODO: add validation
    @PostMapping(path = "/{employeeId}/{shiftId}", consumes = MediaType.APPLICATION_JSON)
    ResponseEntity<EmployeeShiftStub> add(@PathVariable("employeeId") final Long empId,
            @PathVariable("shiftId") final Long shiftId, @RequestBody final EmployeeShift body) throws ServiceException;
}
