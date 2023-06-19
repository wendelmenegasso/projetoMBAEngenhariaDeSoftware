package br.com.mba.engenharia.de.software.controller;

import br.com.mba.engenharia.de.software.negocio.contas.*;
import br.com.mba.engenharia.de.software.negocio.usuarios.Usuario;
import br.com.mba.engenharia.de.software.security.GerarToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController

public class ContaController {
    private static final Logger logger = LoggerFactory.getLogger(Conta.class);

    @GetMapping("/testConta")
    public String testConta(HttpServletRequest request) throws IOException {
        GerarToken gerarToken = new GerarToken();
        Usuario usuario = new Usuario();
        usuario.setCpf("11111111111");
        usuario.setUsername("wmene");
        usuario.setNome("Willian");
        usuario.setEmail("wmene@gmail.com");
        usuario.setSobrenome("Menezes");
        usuario.setSenha("123456");
        usuario.setToken(gerarToken.gerarToken());
        usuario.setId(1);
        Conta conta = new Conta();
        String numeroConta = request.getParameter("conta");
        conta.setConta(numeroConta);
        String agencia = request.getParameter("agencia");
        conta.setAgencia(agencia);
        String valor = request.getParameter("saldo");
        conta.setSaldo(Double.parseDouble(valor));
        String tipo = request.getParameter("tipoConta");
        Tipoconta tipoconta = TipoContaEnum.CC.getTipoconta(Integer.parseInt(tipo));
        conta.setTipo(tipoconta.getId());
        conta.setUsuario(usuario.getId());
        String bancoValue = request.getParameter("banco");
        Banco banco = BancoEnum.BANCO_PAN.getBanco(Integer.parseInt(bancoValue));
        if (banco == null){
            return "Banco não encontrado!";
        }
        conta.setBanco(banco.getId());

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
    @GetMapping("/listarConta")
    public void listarConta(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Conta conta = new Conta();
        String numeroConta = request.getParameter("conta");
        if (numeroConta != null){
            conta.setConta(numeroConta);
        }
        String agencia = request.getParameter("agencia");
        if (agencia != null){
            conta.setAgencia(agencia);
        }
        String tipo = request.getParameter("tipoConta");
        if (tipo != null){
            Tipoconta tipoconta = TipoContaEnum.CC.getTipoconta(Integer.parseInt(tipo));
            conta.setTipo(tipoconta.getId());
        }
        String bancoValue = request.getParameter("banco");
        if (bancoValue != null){
            Banco banco = BancoEnum.BANCO_PAN.getBanco(Integer.parseInt(bancoValue));
            conta.setBanco(banco.getId());
        }

        Controller controller = new Controller();
        PrintWriter printWriter = response.getWriter();
        printWriter.write("<div style=width: 400px;>");
        printWriter.write("<p>Resultado da busca:</p>");
        printWriter.write("<table border=1px width=400px name='table'>");
        printWriter.write("<thread>");
        printWriter.write("<tr>");
        printWriter.write("<th>id</th>");
        printWriter.write("<th>usuario</th>");
        printWriter.write("<th>agencia</th>");
        printWriter.write("<th>conta</th>");
        printWriter.write("<th>saldo</th>");
        printWriter.write("<th>banco</th>");
        printWriter.write("<th>tipo</th>");
        printWriter.write("</tr>");
        printWriter.write("</thread>");
        for (Conta results : controller.consultarConta(conta)) {
            printWriter.write("<thread>");
            printWriter.write("<tr>");
            printWriter.write("<th>"+results.getId() +"</th>");
            printWriter.write("<th>"+results.getUsuario()+"</th>");
            printWriter.write("<th>"+results.getAgencia()+"</th>");
            printWriter.write("<th>"+results.getConta()+"</th>");
            printWriter.write("<th>"+results.getSaldo()+"</th>");
            printWriter.write("<th>"+results.getBanco() +"</th>");
            printWriter.write("<th>"+results.getTipo()+" </th>");
            printWriter.write("</tr>");
            printWriter.write("</thread>");
        }
        printWriter.write("</table>");
        printWriter.write("</div>");
    }
}
