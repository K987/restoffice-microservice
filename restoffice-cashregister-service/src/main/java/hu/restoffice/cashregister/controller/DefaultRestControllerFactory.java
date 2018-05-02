package hu.restoffice.cashregister.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hu.restoffice.cashregister.converter.RegisterCloseConverterService;
import hu.restoffice.cashregister.converter.RegisterConverterService;
import hu.restoffice.cashregister.service.RegisterCloseService;
import hu.restoffice.cashregister.service.RegisterService;
import hu.restoffice.commons.web.DefaultController;

/**
 *
 */
@Configuration
public class DefaultRestControllerFactory {

    @Bean
    public DefaultController registerDefaultController(final RegisterService service, final RegisterConverterService converter) {
        return new DefaultController(service, converter);
    }

    @Bean
    public DefaultController registerCloseDefaultController(final RegisterCloseService service,
            final RegisterCloseConverterService converter) {
        return new DefaultController(service, converter);
    }
}
