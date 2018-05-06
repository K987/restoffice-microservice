package hu.restoffice.commons.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 *
 */
@Configuration
public class RestofficeJwtClientTokenServiceConfiguration {

    private static final Logger log = LogManager.getLogger();

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        log.info("creating token converter....");
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("12345ABCDE");
        return converter;
    }

    @Bean
    public TokenStore tokenStore() {
        log.info("creating token store....");
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    @Primary
    public DefaultTokenServices jwttokenServices() {
        log.info("creating token service....");
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        return defaultTokenServices;
    }
}
