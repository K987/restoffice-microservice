package hu.restoffice.authorization.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 *
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationCongifuration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.oauth2.config.annotation.web.configuration.
     * AuthorizationServerConfigurerAdapter#configure(org.springframework.security.
     * oauth2.config.annotation.web.configurers.
     * AuthorizationServerEndpointsConfigurer)
     */
    @Override
    public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
        .accessTokenConverter(accessTokenConverter());
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.oauth2.config.annotation.web.configuration.
     * AuthorizationServerConfigurerAdapter#configure(org.springframework.security.
     * oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer)
     */
    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
        .withClient("client").secret("{noop}secret").authorizedGrantTypes("password")
        .scopes("read", "write", "admin", "trust").authorities("USER", "ADMIN")
        .and()
        .withClient("readclient").secret("{noop}readSecret").authorizedGrantTypes("password")
        .scopes("read").authorities("USER");
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("12345ABCDE");
        return converter;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.oauth2.config.annotation.web.configuration.
     * AuthorizationServerConfigurerAdapter#configure(org.springframework.security.
     * oauth2.config.annotation.web.configurers.
     * AuthorizationServerSecurityConfigurer)
     */
    @Override
    public void configure(final AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()").tokenKeyAccess("denyAll()");
    }

}
