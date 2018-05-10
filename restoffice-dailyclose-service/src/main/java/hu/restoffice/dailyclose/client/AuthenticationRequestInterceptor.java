package hu.restoffice.dailyclose.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Component
public class AuthenticationRequestInterceptor implements RequestInterceptor {

    private static final String AUTHORIZATION_HEADER = "Authorization";

    private static final String BEARER_TOKEN_TYPE = "Bearer";

    private static final Logger log = LogManager.getLogger();

    @Autowired
    private OAuth2ClientContext oauth2ClientContext;


    @Override
    public void apply(final RequestTemplate template) {
        log.info("adding auth token...");
        if (template.headers().containsKey(AUTHORIZATION_HEADER)) {
            log.info("The Authorization token has been already set");
        } else {
            template.header(AUTHORIZATION_HEADER, String.format("%s %s", BEARER_TOKEN_TYPE,
                    oauth2ClientContext.getAccessTokenRequest().getExistingToken().toString()
                    ));
        }
    }
}