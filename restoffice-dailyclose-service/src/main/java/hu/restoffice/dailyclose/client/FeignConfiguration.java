package hu.restoffice.dailyclose.client;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignFormatterRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import feign.RequestInterceptor;

/**
 *
 */
@Configuration
@EnableOAuth2Client
@EnableFeignClients
public class FeignConfiguration {

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return new AuthenticationRequestInterceptor();
    }

    @Bean
    public FeignFormatterRegistrar IsoDateTimeFormatter() {
        return new FeignFormatterRegistrar() {

            @Override
            public void registerFormatters(final FormatterRegistry registry) {
                DateTimeFormatterRegistrar r = new DateTimeFormatterRegistrar();
                r.setUseIsoFormat(true);
                r.registerFormatters(registry);
            }
        };
    }
}
