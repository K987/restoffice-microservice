package hu.restoffice.transaction.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
@RefreshScope
public class ServiceProperties {

    @Value("${spring.application.name}")
    private String serviceName = "";

    @Value("${message}")
    private String message = "";

    public String getServiceName() {
        return serviceName;
    }

    public String getMassage() {
        return message;
    }
}