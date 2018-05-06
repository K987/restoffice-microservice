package hu.restoffice.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RestofficeAuthorizationServerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(RestofficeAuthorizationServerApplication.class, args);
    }
}
