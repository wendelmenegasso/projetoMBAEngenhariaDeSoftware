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
public class WebServletConta{
    @Bean
    List<Filter> springSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(
                        authorizeConfig -> {
                            authorizeConfig.antMatchers("/cadastrarConta").permitAll();
                            authorizeConfig.antMatchers("/consultarConta").permitAll();
                            authorizeConfig.antMatchers("/menuConta").permitAll();
                            authorizeConfig.antMatchers("/contaCadastradaComSucesso").permitAll();
                            authorizeConfig.antMatchers("/testConta").permitAll();
                            authorizeConfig.antMatchers("/cadastrarUsuario").permitAll();
                            authorizeConfig.antMatchers("/enviarCadastro").permitAll();
                            authorizeConfig.anyRequest().authenticated();
                        })
                .oauth2Login(Customizer.withDefaults())
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::disable)
                .build().getFilters();
    }
}
