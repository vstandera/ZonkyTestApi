package com.test.zonky;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import java.util.Collections;

@Configuration
@EnableOAuth2Client
@EnableWebSecurity
public class KeycloakClientCredentialsConfig extends WebSecurityConfigurerAdapter {
    @Value("${security.oauth2.client.clientid}")
    private String clientId;

    @Value("${security.oauth2.client.clientSecret}")
    private String clientSecret;

    @Value("${security.oauth2.client.accessTokenUri}")
    private String accessTokenUri;

    @Value("${security.oauth2.client.userAuthorizationUri}")
    private String userAuthorizationUri;

    @Value("${security.oauth2.client.password}")
    private String password;

    @Value("${security.oauth2.client.username}")
    private String userName;

    @Value("${security.oauth2.client.granttype}")
    private String grantType;

    @Override
    public void configure( final WebSecurity web ) throws Exception {
        web.ignoring().antMatchers( "/**");
    }

    @Override
    protected void configure( final HttpSecurity http ) throws Exception {
        super.configure( http );
    }

    @Bean
    public OAuth2ProtectedResourceDetails oAuth2ProtectedResourceDetails() {

        ResourceOwnerPasswordResourceDetails resourceOwnerPasswordResourceDetails = new ResourceOwnerPasswordResourceDetails();
        resourceOwnerPasswordResourceDetails.setPassword(password);
        resourceOwnerPasswordResourceDetails.setUsername(userName);
        resourceOwnerPasswordResourceDetails.setGrantType(grantType);
        resourceOwnerPasswordResourceDetails.setScope(Collections.singletonList("SCOPE_APP_WEB"));
        resourceOwnerPasswordResourceDetails.setAccessTokenUri(accessTokenUri);
        resourceOwnerPasswordResourceDetails.setClientSecret(clientSecret);
        resourceOwnerPasswordResourceDetails.setClientId(clientId);
        return resourceOwnerPasswordResourceDetails;
    }

    @Bean
    public OAuth2RestTemplate createRestTemplate(OAuth2ClientContext clientContext) {
        return new OAuth2RestTemplate(oAuth2ProtectedResourceDetails(), clientContext);
    }
}

