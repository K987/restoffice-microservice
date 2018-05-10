package hu.restoffice.dailyclose;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("hu.restoffice")
public class RestofficeDailycloseServiceApplication {

    public static void main(final String[] args) {
        SpringApplication.run(RestofficeDailycloseServiceApplication.class, args);
    }

}
