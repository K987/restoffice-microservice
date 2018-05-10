package hu.restoffice.dailyclose.controller;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.dailyclose.domain.RegisterDailyCloseStub;
import hu.restoffice.dailyclose.service.DailyCloseServiceImpl;

/**
 *
 */
@RestController
@RequestMapping("/daily-close")
public class DailyCloseControllerImpl {

    private static final Logger log = LogManager.getLogger();


    @Autowired
    private DailyCloseServiceImpl service;

    @PostMapping(path = "/start/{date}")
    public ResponseEntity<?> startClose(@PathVariable("date") @DateTimeFormat(iso = ISO.DATE) final LocalDate date)
            throws ServiceException {

        Long id = service.startDailyClose(date);
        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri())
                .build();
    }

    @GetMapping(path="/start/{id}/closeRegisters")
    public ResponseEntity<?> closeRegisters(@PathVariable("id") final Long id) throws ServiceException {
        log.info("id is" + id);
        List<RegisterDailyCloseStub> closes = service.closeRegisters(id);
        return ResponseEntity.ok(closes);
    }
}
