package br.com.mba.engenharia.de.software.controller;

import br.com.mba.engenharia.de.software.negocio.account.Banco;
import br.com.mba.engenharia.de.software.negocio.account.Conta;
import br.com.mba.engenharia.de.software.negocio.account.TipoConta;
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
        Conta conta = new Conta();
        conta.setTipo((short) TipoConta.CC.busca(request.getParameter("tipoConta")));
        conta.setBanco((short) Banco.SANTANDER.busca(request.getParameter("banco")));
        conta.setNumeroConta("9000");
        conta.setAgencia("0110");
        conta.setIdUsuario(usuario.getId());
        Controller controller = new Controller(usuario);
        controller.cadastrarConta(conta);
        logger.info(String.format("Usuário id=%d cadastrou corretamente conta=%s  banco=%d",usuario.getId(), conta.getNumeroConta(), conta.getBanco()));
        return "Cadastrado com sucesso<input type=hidden name=idUser value="+usuario.getId()+">";
    }
}
