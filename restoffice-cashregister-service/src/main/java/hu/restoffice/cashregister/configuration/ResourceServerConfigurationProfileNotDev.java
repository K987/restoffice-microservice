package hu.restoffice.cashregister.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;

import hu.restoffice.commons.ServiceProperties;

/**
 *
 */
@Configuration
@Profile("test")
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfigurationProfileNotDev extends ResourceServerConfigurerAdapter {

    private static final Logger log = LogManager.getLogger();

    @Autowired
    private ServiceProperties properties;

    @Autowired
    private DefaultTokenServices defaultTokenservice;

    @Override
    public void configure(final ResourceServerSecurityConfigurer config) {
        log.info("configuring test resource server");
        log.info(defaultTokenservice);
        config.tokenServices(defaultTokenservice).resourceId(properties.getServiceName());
    }

    // @Override
    // public void configure(final HttpSecurity http) throws Exception {
    // log.info("configuring test path security");
    // http.requestMatchers().antMatchers("/**").and().authorizeRequests()
    // .antMatchers(HttpMethod.POST, "/**").access("#oauth2.hasScope(write)")
    // .antMatchers(HttpMethod.DELETE, "/**").access("#oauth2.hasScope(write)")
    // .antMatchers(HttpMethod.PUT, "/**").access("#oauth2.hasScope(write)")
    // .antMatchers("/actuator/**").access("#oauth2.hasScope('trust')");
    // }
}
