package hu.restoffice.cashregister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import hu.restoffice.cashregister.converter.RegisterCloseConverterService;
import hu.restoffice.cashregister.converter.RegisterConverterService;
import hu.restoffice.cashregister.service.RegisterCloseService;
import hu.restoffice.cashregister.service.RegisterService;
import hu.restoffice.commons.web.DefaultController;

@ComponentScan("hu.restoffice")
@SpringBootApplication
@EnableEntityLinks
public class RestofficeCashregisterServiceApplication {

    public static void main(final String[] args) {
        SpringApplication.run(RestofficeCashregisterServiceApplication.class, args);
    }

    @Bean
    public CommonsRequestLoggingFilter log() {
        return new CommonsRequestLoggingFilter();
    }

    @Bean
    public DefaultController registerDefaultController(final RegisterService service,
            final RegisterConverterService converter) {
        return new DefaultController(service, converter);
    }

    @Bean
    public DefaultController registerCloseDefaultController(final RegisterCloseService service,
            final RegisterCloseConverterService converter) {
        return new DefaultController(service, converter);
    }

}
