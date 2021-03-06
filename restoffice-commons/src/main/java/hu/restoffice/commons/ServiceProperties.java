package hu.restoffice.commons;

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

    @Value("${server.port}")
    private String port;

    public String getServiceName() {
        return serviceName;
    }


    public String getPort() {
        return port;
    }
}
