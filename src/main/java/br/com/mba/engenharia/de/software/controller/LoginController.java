package br.com.mba.engenharia.de.software.controller;

import br.com.mba.engenharia.de.software.model.login.Login;
import br.com.mba.engenharia.de.software.negocio.user.Usuario;
import br.com.mba.engenharia.de.software.security.Criptrografia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController

public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(Login.class);
    @GetMapping("/loginFailure")
    String loginFailure() {
        return "login falhou";
    }
    @GetMapping("/logout")
    String logout() {
        return "logout";
    }
    @GetMapping("testLogin")
    String testLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        Usuario usuario = new Usuario(userName, password);
        Criptrografia criptrografia = new Criptrografia();
        if(userName.equals("wendel") && criptrografia.criptrografia(password)){
            response.sendRedirect("/home?id=1");
            return "/home";
        }
        else{
            response.sendRedirect("/loginFailure");
            return "/loginFailure";
        }
    }
}
