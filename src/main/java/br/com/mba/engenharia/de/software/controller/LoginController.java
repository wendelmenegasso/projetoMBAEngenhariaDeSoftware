package br.com.mba.engenharia.de.software.controller;

import br.com.mba.engenharia.de.software.model.login.Login;
import br.com.mba.engenharia.de.software.negocio.usuarios.Usuario;
import br.com.mba.engenharia.de.software.negocio.usuarios.UsuarioRepository;
import br.com.mba.engenharia.de.software.security.Criptrografia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Component
@RestController
public class LoginController{
    private static final Logger logger = LoggerFactory.getLogger(Login.class);
    @GetMapping("/loginFailure")
    String loginFailure() {
        return "login falhou";
    }
    @GetMapping("/redirectLogout")
    public String logout() {
        return "logout";
    }
    @GetMapping("/testLogin")
    public String testLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletResponse response) throws IOException {
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        Criptrografia criptrografia = new Criptrografia();
        usuario.setSenha(criptrografia.criptografar(password));
        Controller controller = new Controller();
        controller.setController(usuario);
        if(username.equals("professor@gmail.com") && criptrografia.criptrografia(password)){
            response.sendRedirect("/home");
        }
        else if (username.equals("admin@gmail.com") && password.equals("Fsa@41306")){
            response.sendRedirect("/admin");
        }
        else if (controller.consultarUsuario()){
            response.sendRedirect("/home");
        }
        else {
            response.sendRedirect("/loginFailure");
        }
        return null;
    }
}
