package hu.restoffice.cashregister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("hu.restoffice")
@SpringBootApplication
public class RestofficeCashregisterServiceApplication {

    public static void main(final String[] args) {
        SpringApplication.run(RestofficeCashregisterServiceApplication.class, args);
    }
}
