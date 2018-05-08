package hu.restoffice.gateway.properties;

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

    @Value("${info.app.message}")
    private String message = "";

    @Value("${server.port}")
    private String port;

    @Value("${restoffice.auth-endpoint.url}")
    private String tokenPath;

    @Value("${restoffice.correlation-filter.enable}")
    private String correlationFilterUse = "";

    public String getServiceName() {
        return serviceName;
    }

    public String getMassage() {
        return message;
    }

    public String getPort() {
        return port;
    }

    /**
     * @return
     */
    public String getTokenPath() {
        return tokenPath;
    }

    /**
     * @return
     */
    public Boolean isCorreletaionFilterEnabled() {
        return Boolean.valueOf(correlationFilterUse.trim());
    }
}
