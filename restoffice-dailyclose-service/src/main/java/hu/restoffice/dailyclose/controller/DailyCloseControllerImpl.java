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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.dailyclose.converter.RegisterDailyCloseConverter;
import hu.restoffice.dailyclose.converter.ShiftDailyCloseConverter;
import hu.restoffice.dailyclose.domain.RegisterDailyCloseStub;
import hu.restoffice.dailyclose.domain.ShiftDailyCloseStub;
import hu.restoffice.dailyclose.service.DailyCloseService;

/**
 *
 */
@RestController
@RequestMapping("/")
public class DailyCloseControllerImpl {

    private static final Logger log = LogManager.getLogger();

    @Autowired
    private DailyCloseService service;

    @Autowired
    private RegisterDailyCloseConverter registerDailyCloseConverter;

    @Autowired
    private ShiftDailyCloseConverter shiftDailyCloseConverter;

    @PostMapping(path = "/start/{date}")
    public ResponseEntity<?> startClose(@PathVariable("date") @DateTimeFormat(iso = ISO.DATE) final LocalDate date)
            throws ServiceException {

        Long id = service.startDailyClose(date);
        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(id).toUri())
                .build();
    }

    @GetMapping(path="/{id}/closeRegisters")
    public ResponseEntity<?> closeRegisters(@PathVariable("id") final Long id) throws ServiceException {
        log.info("id is" + id);
        List<RegisterDailyCloseStub> closes = registerDailyCloseConverter.from(service.closeRegisters(id));
        return ResponseEntity.ok(closes);
    }

    @GetMapping(path = "/{id}/closeShift")
    public ResponseEntity<?> getCloseShift(@PathVariable("id") final Long id) throws ServiceException {
        List<ShiftDailyCloseStub> toBeClosed = service.getShiftsToClose(id);
        return ResponseEntity.ok(toBeClosed);
    }

    @PostMapping(path = "/{id}/closeShift")
    public ResponseEntity<?> closeShift(@PathVariable("id") final Long id,
            @RequestBody final List<ShiftDailyCloseStub> stubs) throws ServiceException {

        List<ShiftDailyCloseStub> rtrn = shiftDailyCloseConverter.from(service.closeShifts(id, stubs));
        return ResponseEntity.ok(rtrn);

    }

    @PostMapping(path = "/{id}/finish")
    public ResponseEntity<?> finishClose(@PathVariable("id") final Long id) throws ServiceException {
        service.finishCloseDay(id);
        return ResponseEntity.noContent().build();
    }

}
