package br.com.mba.engenharia.de.software.controller;

import br.com.mba.engenharia.de.software.negocio.usuarios.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UsuarioController {
    private static final Logger logger = LoggerFactory.getLogger(Usuario.class);
    @GetMapping("/redirectCadastrarUsuario")
    public String cadastrarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
            response.sendRedirect("/cadastrarUsuario");
            return null;
    }
    @GetMapping("/enviarCadastro")
    public Object enviarCadastro(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("Enviado com sucesso, por favor ative o usuário, para maiores informações foi enviado um e-mail para o e-mail cadastrado");
        return null;
    }
}

