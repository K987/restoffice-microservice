package hu.restoffice.dailyclose.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 *
 */
@Configuration
// @Profile("test")
@EnableResourceServer
// @EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfigurationProfileNotDev extends ResourceServerConfigurerAdapter {

    private static final Logger log = LogManager.getLogger();

    // @Autowired
    // private ServiceProperties properties;

    @Autowired
    private DefaultTokenServices defaultTokenservice;

    @Override
    public void configure(final ResourceServerSecurityConfigurer config) {
        log.info("configuring test resource server");
        log.info(defaultTokenservice);
        config.tokenServices(defaultTokenservice).resourceId("restoffice-dailyclose-service");
    }

    @Override
    public void configure(final HttpSecurity http) throws Exception {
        log.info("configuring test path security");
        http.authorizeRequests().antMatchers("/**").permitAll();
    }

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
