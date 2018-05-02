package hu.restoffice.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@ComponentScan("hu.restoffice")
@SpringBootApplication
public class RestofficeEmployeeServiceApplication {

    public static void main(final String[] args) {
        SpringApplication.run(RestofficeEmployeeServiceApplication.class, args);
    }

    @Bean
    public CommonsRequestLoggingFilter log() {
        return new CommonsRequestLoggingFilter();
    }
}
