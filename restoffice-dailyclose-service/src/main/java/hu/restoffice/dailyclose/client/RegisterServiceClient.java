package hu.restoffice.dailyclose.client;

import java.time.LocalDate;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hu.restoffice.dailyclose.domain.RegisterCloseStub;

/**
 *
 */
@FeignClient("restoffice-cashregister-service")
public interface RegisterServiceClient {

    @GetMapping(path = "/register-close", params = { "fromDate", "toDate" })
    ResponseEntity<List<RegisterCloseStub>> findClosesesBetweenDate(
            @RequestParam("fromDate") @DateTimeFormat(iso = ISO.DATE) final LocalDate from,
            @RequestParam("toDate") @DateTimeFormat(iso = ISO.DATE) LocalDate to);

    @GetMapping(path="/register")
    ResponseEntity<List<RegisterStub>> getRegisters();
}
