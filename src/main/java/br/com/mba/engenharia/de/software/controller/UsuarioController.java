package br.com.mba.engenharia.de.software.controller;

import br.com.mba.engenharia.de.software.negocio.usuarios.Usuario;
import br.com.mba.engenharia.de.software.security.Criptrografia;
import br.com.mba.engenharia.de.software.security.GerarToken;
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
        Usuario usuario = new Usuario();
        GerarToken gerarToken = new GerarToken();
        usuario.setToken(gerarToken.gerarToken());
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        Criptrografia criptrografia = new Criptrografia();
        String senha = criptrografia.gerarHash(request.getParameter("senha"));
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String cpf = request.getParameter("cpf");
        usuario.setUsername(username);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setNome(nome);
        usuario.setSobrenome(sobrenome);
        usuario.setCpf(cpf);
        return null;
    }
}

