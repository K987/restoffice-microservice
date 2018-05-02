package hu.restoffice.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("hu.restoffice")
@SpringBootApplication
@EnableEurekaClient
public class RestofficeTransactionServiceApplication {

    public static void main(final String[] args) {
        SpringApplication.run(RestofficeTransactionServiceApplication.class, args);
    }
}