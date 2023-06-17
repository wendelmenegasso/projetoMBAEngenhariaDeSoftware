package br.com.mba.engenharia.de.software.controller;

import br.com.mba.engenharia.de.software.negocio.account.Conta;
import br.com.mba.engenharia.de.software.negocio.account.Contas;
import br.com.mba.engenharia.de.software.negocio.user.Usuario;
import br.com.mba.engenharia.de.software.security.GerarToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController

public class ContaController {
    private static final Logger logger = LoggerFactory.getLogger(Contas.class);

    @GetMapping("/testConta")
    public String testConta(HttpServletRequest request) throws IOException {
        GerarToken gerarToken = new GerarToken();
        Usuario usuario = new Usuario("wendel","fsa41306", "wendel.s.menegasso@gmail.com", gerarToken.gerarToken());
        Conta conta = new Conta();
        String numeroConta = request.getParameter("conta");
        conta.setConta(numeroConta);
        String agencia = request.getParameter("agencia");
        conta.setAgencia(agencia);
        String valor = request.getParameter("saldo");
        conta.setSaldo(Double.parseDouble(valor));
        String tipo = request.getParameter("tipoConta");
        conta.setTipo(Integer.parseInt(tipo));
        String banco = request.getParameter("banco");
        conta.setBanco(Integer.parseInt(banco));

        Controller controller = new Controller(usuario);
        if (controller.cadastrarConta(conta)){
            logger.info(String.format("Usuário cadastrado corretamente"));
            return "Cadastrado com sucesso<input type=hidden name=idUser>";
        }
        else {
            logger.info(String.format("Erro na conexao"));
            return "Erro na conexao";
        }
    }
}
