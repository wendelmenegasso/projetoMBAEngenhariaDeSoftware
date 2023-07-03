package br.com.mba.engenharia.de.software.servlets;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import javax.servlet.Filter;
import java.util.List;


@Configuration
@EnableWebSecurity
public class WebServletLogin{
    @Bean
    List<Filter> springSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(
                        authorizeConfig -> {
                            authorizeConfig.antMatchers("/").permitAll();
                            authorizeConfig.antMatchers("/logout").permitAll();
                            authorizeConfig.antMatchers("/loginFailure").permitAll();
                            authorizeConfig.antMatchers("/home").permitAll();
                            authorizeConfig.anyRequest().authenticated();
                        })
                .oauth2Login(Customizer.withDefaults())
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::disable)
                .build().getFilters();

    }
}
