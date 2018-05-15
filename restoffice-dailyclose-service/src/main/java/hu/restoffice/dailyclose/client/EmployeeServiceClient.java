package hu.restoffice.dailyclose.client;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hu.restoffice.commons.error.ServiceException;

/**
 *
 */
@FeignClient("restoffice-employee-service")
public interface EmployeeServiceClient {

    @GetMapping(path = "/employee-shift", params = { "day" })
    public ResponseEntity<List<EmployeeShiftStub>> getEmployeeShiftsOfDay(
            @RequestParam("day") @NotNull @DateTimeFormat(iso = ISO.DATE) final LocalDate day) throws ServiceException;

}
