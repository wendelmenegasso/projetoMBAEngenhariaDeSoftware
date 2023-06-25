package br.com.mba.engenharia.de.software.config;

import br.com.mba.engenharia.de.software.service.MyUserDetailsService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 *
 * @author Nataniel Paiva <nataniel.paiva@gmail.com>
 */
@Configuration
public class OAuth2ServerConfiguration {

    private static final String RESOURCE_ID = "restservice";
    @Getter
    private ResourceServerConfiguration resourceServerConfiguration;

    @Configuration
    @EnableResourceServer
    public static class ResourceServerConfiguration extends
            ResourceServerConfigurerAdapter {

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
            resources
                    .resourceId(RESOURCE_ID);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().antMatchers("/", "/error","/webjars/**").permitAll().anyRequest().authenticated()
                    .and()
                    .exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                    .and()
                    .oauth2Login()
                    .and()
                    .logout().logoutSuccessUrl("/").permitAll()
                    .and()
                    .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                    .and()
                    .oauth2Login().failureHandler((request, response, exception) -> {
                                request.getSession().setAttribute("error.message", exception.getMessage());
                            }
                    );

        }

        @Configuration
        @EnableAuthorizationServer
        protected static class AuthorizationServerConfiguration extends
                AuthorizationServerConfigurerAdapter {

            private TokenStore tokenStore = new InMemoryTokenStore();

            @Autowired
            @Qualifier("authenticationManagerBean")
            private AuthenticationManager authenticationManager;

            private MyUserDetailsService userDetailsService;

            @Autowired
            private PasswordEncoder passwordEncoder;

            @Override
            public void configure(AuthorizationServerEndpointsConfigurer endpoints)
                    throws Exception {
                endpoints
                        .tokenStore(this.tokenStore)
                        .authenticationManager(this.authenticationManager)
                        .userDetailsService(userDetailsService)
                        .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
            }

            @Override
            public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
                clients
                        .inMemory()
                        .withClient("client")
                        .authorizedGrantTypes("password", "authorization_code", "refresh_token").scopes("all")
                        .refreshTokenValiditySeconds(300000)
                        .resourceIds(RESOURCE_ID)
                        .secret(passwordEncoder.encode("123"))
                        .accessTokenValiditySeconds(50000)
                ;
            }

            @Bean
            @Primary
            public DefaultTokenServices tokenServices() {
                DefaultTokenServices tokenServices = new DefaultTokenServices();
                tokenServices.setSupportRefreshToken(true);
                tokenServices.setTokenStore(this.tokenStore);
                return tokenServices;
            }
        }
    }
}
