package hu.restoffice.transaction.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RefreshScope
public class TransactionRestController {

    @Value("${message}")
    private String message;

    @RequestMapping("/message")
    public String message(final Principal principal) {
        return message + " " + principal.getName();
    }

    @RequestMapping(path = "/message", method = RequestMethod.POST)
    public String message(final String body) {
        return "Hello";
    }
}
