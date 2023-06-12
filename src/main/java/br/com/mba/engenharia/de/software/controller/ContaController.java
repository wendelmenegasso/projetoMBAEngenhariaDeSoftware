package br.com.mba.engenharia.de.software.controller;

import br.com.mba.engenharia.de.software.negocio.account.Conta;
import br.com.mba.engenharia.de.software.negocio.user.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController

public class ContaController {
    private static final Logger logger = LoggerFactory.getLogger(Conta.class);
    @GetMapping("/testConta")
    String testConta(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Usuario usuario = new Usuario();
        usuario.setId(1);
        Controller controller = new Controller(usuario);
        controller.cadastrarConta();
        return "Cadastrado com sucesso";
    }
}
