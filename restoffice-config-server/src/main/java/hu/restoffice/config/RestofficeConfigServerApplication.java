package hu.restoffice.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class RestofficeConfigServerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(RestofficeConfigServerApplication.class, args);
    }
}
