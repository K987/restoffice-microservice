package hu.restoffice.dailyclose.controller;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.restoffice.dailyclose.client.CashRegisterCloseClient;

/**
 *
 */
@RestController
@RequestMapping("/daily-close")
public class TestController {

    private static final Logger log = LogManager.getLogger();

    @Autowired
    private CashRegisterCloseClient client;

    @GetMapping
    public ResponseEntity<?> getCloses() {
        ResponseEntity<List<?>> resp = null;
        List<?> body = null;
        try {
            log.info("invoking feign client");
            resp = client.findResourceByDate(LocalDate.of(2018, 5, 10), LocalDate.of(2018, 5, 30));
            body = resp.getBody();
            log.info("invocation is ok");
        } catch (Exception e) {
            log.error(e);
            return ResponseEntity.ok(e.getMessage());

        }
        return ResponseEntity.ok(body);
    }

}
