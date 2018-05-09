package hu.restoffice.cashregister.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hu.restoffice.cashregister.domain.RegisterCloseStub;
import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.web.CRUDController;

/**
 *
 */
public interface RegisterCloseController extends CRUDController<RegisterCloseStub> {

    @GetMapping(params = { "fromDate", "toDate" })
    ResponseEntity<List<?>> findResourceByDate(
            @RequestParam("fromDate") @DateTimeFormat(iso = ISO.DATE) final LocalDate from,
            @RequestParam("toDate") @DateTimeFormat(iso = ISO.DATE) final LocalDate to) throws ServiceException;

    @GetMapping(path = "/lastCloses")
    ResponseEntity<List<?>> getLastCloses() throws ServiceException;

}
