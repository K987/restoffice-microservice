package hu.restoffice.employee.configuration;

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
@Profile("!development")
@EnableResourceServer
@EnableGlobalMethodSecurity(securedEnabled = true)
public class ResourceServerConfigurationProfileNotDev extends ResourceServerConfigurerAdapter {

    @Autowired
    private ServiceProperties properties;

    @Autowired
    private DefaultTokenServices tokenService;

    @Override
    public void configure(final ResourceServerSecurityConfigurer config) {
        config.tokenServices(tokenService).resourceId(properties.getServiceName());
    }

    // /*
    // * (non-Javadoc)
    // *
    // * @see
    // org.springframework.security.oauth2.config.annotation.web.configuration.
    // *
    // ResourceServerConfigurerAdapter#configure(org.springframework.security.config
    // * .annotation.web.builders.HttpSecurity)
    // */
    // @Override
    // public void configure(final HttpSecurity http) throws Exception {
    // http.csrf().disable().requestMatchers().antMatchers("/**").and().authorizeRequests()
    // .antMatchers(HttpMethod.POST, "/**").access("#oauth2.hasScope(write)")
    // .antMatchers(HttpMethod.DELETE, "/**").access("#oauth2.hasScope(write)")
    // .antMatchers(HttpMethod.PUT, "/**").access("#oauth2.hasScope(write)")
    // .antMatchers("/actuator/**").access("#oauth2.hasScope('trust')");
    // }
}
