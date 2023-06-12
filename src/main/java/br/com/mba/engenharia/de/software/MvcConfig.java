package br.com.mba.engenharia.de.software;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login.html");
        registry.addViewController("/home").setViewName("conta.html");
        registry.addViewController("/contaCadastradaComSucesso").setViewName("sucesso.html");
        registry.addViewController("/logout");
        registry.addViewController("/testConta");
        registry.addViewController("/loginFailure");
    }
}
