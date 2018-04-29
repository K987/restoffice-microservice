package hu.restoffice.transaction.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hu.restoffice.transaction.service.TransactionService;

/**
 *
 */
@RestController
public class TransactionRestController {

    @Autowired
    TransactionService transactionService;

    @RequestMapping("/message")
    public String message(final Principal principal) {
        return transactionService.getMessage(null, "az") + " user name: " + principal.getName();
    }

    @RequestMapping(path = "/message", method = RequestMethod.POST)
    public String message(final String body) {
        return "Hello";
    }
}
