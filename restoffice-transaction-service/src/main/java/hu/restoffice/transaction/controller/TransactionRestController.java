package hu.restoffice.transaction.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hu.restoffice.transaction.properties.ServiceProperties;

/**
 *
 */
@RestController
@RefreshScope
public class TransactionRestController {

    @Autowired
    private ServiceProperties properties;

    @RequestMapping("/message")
    public String message(final Principal principal) {
        return properties.getMassage() + " " + principal.getName();
    }

    @RequestMapping(path = "/message", method = RequestMethod.POST)
    public String message(final String body) {
        return "Hello";
    }
}
