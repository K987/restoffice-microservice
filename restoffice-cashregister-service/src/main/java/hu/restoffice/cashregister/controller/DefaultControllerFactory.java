package hu.restoffice.cashregister.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hu.restoffice.cashregister.converter.RegisterConverterService;
import hu.restoffice.cashregister.entity.Register;
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
        return new DefaultController(service, converter) {

            @Override
            protected Long getId(final Object id) {
                if (id instanceof Register) {
                    Register r = (Register) id;
                    return r.getId();
                } else {
                    throw new RuntimeException("Casting to object to Register failed... cant retrieve id");
                }
            }
        };
    }
}
