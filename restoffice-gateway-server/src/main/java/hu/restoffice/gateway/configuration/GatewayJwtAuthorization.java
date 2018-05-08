package hu.restoffice.gateway.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;

import hu.restoffice.gateway.properties.ServiceProperties;

/**
 *
 */
@Configuration
@EnableResourceServer
public class GatewayJwtAuthorization extends ResourceServerConfigurerAdapter {

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

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.oauth2.config.annotation.web.configuration.
     * ResourceServerConfigurerAdapter#configure(org.springframework.security.config
     * .annotation.web.builders.HttpSecurity)
     */
    @Override
    public void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(properties.getTokenPath()).permitAll().antMatchers("/**").authenticated()
        .and().csrf()
        .disable();
    }

}
