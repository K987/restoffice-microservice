package hu.restoffice.dailyclose.client;

import java.time.LocalDate;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 */
@FeignClient("restoffice-cashregister-service")
public interface CashRegisterCloseClient {

    @GetMapping(path = "/register-close", params = { "fromDate", "toDate" })
    ResponseEntity<List<?>> findResourceByDate(
            @RequestParam("fromDate") @DateTimeFormat(iso = ISO.DATE) final LocalDate from,
            @RequestParam("toDate") @DateTimeFormat(iso = ISO.DATE) LocalDate to);
}
