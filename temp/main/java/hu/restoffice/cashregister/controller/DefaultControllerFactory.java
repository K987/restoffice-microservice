package hu.restoffice.cashregister.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hu.restoffice.cashregister.converter.RegisterConverterService;
import hu.restoffice.cashregister.service.RegisterService;
import hu.restoffice.commons.DefaultController;

/**
 *
 */
@Configuration
public class DefaultControllerFactory {

    @Bean
    public DefaultController registerControllerDefault(
            final RegisterService service,
            final RegisterConverterService converter) {
        return new DefaultController(service, converter);
    }


}
