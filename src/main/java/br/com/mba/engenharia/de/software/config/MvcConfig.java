package br.com.mba.engenharia.de.software.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index.html");
        registry.addViewController("/cadastrarConta").setViewName("conta/conta.html");
        registry.addViewController("/consultarConta").setViewName("conta/consultarConta.html");
        registry.addViewController("/menuConta").setViewName("conta/menuConta.html");
        registry.addViewController("/contaCadastradaComSucesso").setViewName("sucesso.html");
        registry.addViewController("/logout");
        registry.addViewController("/testConta");
        registry.addViewController("/loginFailure");
        registry.addViewController("/home").setViewName("menu/menuPrincipalComMenuEmCima.html");
        registry.addViewController("/cadastrarUsuario").setViewName("/usuario/cadastrarUsuario.html");
        registry.addViewController("/cookie");
        registry.addViewController("/login/oauth2/code/google");
        registry.addViewController("/usuarioHabilitado").setViewName("menu/menuPrincipalComMenuEmCima.html");
        registry.addViewController("/usuarioDesabilitado").setViewName("/usuario/ativarUsuario.html");
        registry.addViewController("/habilitar").setViewName("/usuario/ativarUsuario.html");
    }
}
