package hu.restoffice.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RestofficeServiceRegistryServerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(RestofficeServiceRegistryServerApplication.class, args);
    }
}
