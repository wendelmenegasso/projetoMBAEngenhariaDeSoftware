package br.com.mba.engenharia.de.software.controller;

import br.com.mba.engenharia.de.software.negocio.contas.Banco;
import br.com.mba.engenharia.de.software.negocio.contas.Contas;
import br.com.mba.engenharia.de.software.negocio.contas.Tipoconta;
import br.com.mba.engenharia.de.software.negocio.usuarios.Usuarios;
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
        Usuarios usuario = new Usuarios();
        usuario.setCpf("11111111111");
        usuario.setUsername("wmene");
        usuario.setNome("Willian");
        usuario.setEmail("wmene@gmail.com");
        usuario.setSobrenome("Menezes");
        usuario.setSenha("123456");
        usuario.setToken(gerarToken.gerarToken());
        usuario.setId(1);
        Contas conta = new Contas();
        String numeroConta = request.getParameter("conta");
        conta.setConta(numeroConta);
        String agencia = request.getParameter("agencia");
        conta.setAgencia(agencia);
        String valor = request.getParameter("saldo");
        conta.setSaldo(Double.parseDouble(valor));
        String tipo = request.getParameter("tipoConta");
        Tipoconta tipoconta = new Tipoconta();
        tipoconta.setId(Integer.parseInt(tipo));
        conta.setTipo(tipoconta);
        String bancoValue = request.getParameter("banco");
        Banco banco = new Banco();
        banco.setId(Integer.parseInt(bancoValue));
        conta.setBanco(banco);

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
