package br.com.mba.engenharia.de.software.controller;

import br.com.mba.engenharia.de.software.negocio.account.Banco;
import br.com.mba.engenharia.de.software.negocio.account.Conta;
import br.com.mba.engenharia.de.software.negocio.account.TipoConta;
import br.com.mba.engenharia.de.software.negocio.user.Usuario;
import br.com.mba.engenharia.de.software.security.GerarToken;
import br.com.mba.engenharia.de.software.service.ContaService;

import javax.servlet.http.HttpServletRequest;

public class Controller {
    private Usuario usuario;
    public Controller(Usuario usuario){
        this.usuario = usuario;
    }

    public void cadastrarConta(Conta conta){
        usuario.setEmail("teste@teste.com.br");
        usuario.setNome("Arnaldo");
        usuario.setSenha("123456");
        usuario.setId(usuario.getId());
        GerarToken gerarToken = new GerarToken();
        usuario.setToken(gerarToken.gerarSenhaAleatoria());

        ContaService contaService = new ContaService(conta);
        contaService.salvar();
    }
}
