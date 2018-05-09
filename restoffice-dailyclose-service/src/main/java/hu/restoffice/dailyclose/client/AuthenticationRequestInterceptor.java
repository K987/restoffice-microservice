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

    // public AuthenticationRequestInterceptor(final OAuth2ClientContext
    // oauth2ClientContext) {
    // this.oauth2ClientContext = oauth2ClientContext;
    // }

    @Override
    public void apply(final RequestTemplate template) {

        if (template.headers().containsKey(AUTHORIZATION_HEADER)) {
            log.info("The Authorization token has been already set");
            // } else if (oauth2ClientContext.getAccessTokenRequest().getExistingToken() ==
            // null) {
            // log.info("Can not obtain existing token for request, if it is a non secured
            // request, ignore.");
        } else {
            log.info("Constructing Header {} for Token {}", AUTHORIZATION_HEADER, BEARER_TOKEN_TYPE);
            template.header(AUTHORIZATION_HEADER, String.format("%s %s", BEARER_TOKEN_TYPE,
                    oauth2ClientContext.getAccessTokenRequest().getExistingToken().toString()
                    // "
                    // eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MjU4MTI5NjgsInVzZXJfbmFtZSI6InVzZXIiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiZWY0YzhhZjAtNWM1Ny00OTRmLWE0YzUtOGVkZmQ0NzgwNDlmIiwiY2xpZW50X2lkIjoicmVhZGNsaWVudCIsInNjb3BlIjpbInJlYWQiXX0.LHjq85Gbh0qNti-YhhYcF4uRO9Qsp8s0pskFAEAYZCs"
                    ));
        }
    }
}