package br.com.mba.engenharia.de.software.controller;

import br.com.mba.engenharia.de.software.negocio.account.Banco;
import br.com.mba.engenharia.de.software.negocio.account.Conta;
import br.com.mba.engenharia.de.software.negocio.account.TipoConta;
import br.com.mba.engenharia.de.software.negocio.user.Usuario;
import br.com.mba.engenharia.de.software.service.ContaService;

public class Controller {
    private Usuario usuario;
    public Controller(Usuario usuario){
        this.usuario = usuario;
    }

    public void cadastrarConta(){
        usuario.setEmail("teste@teste.com.br");
        usuario.setNome("Arnaldo");
        usuario.setSenha("123456");
        usuario.setId(usuario.getId());
        usuario.setToken("123456789");

        Conta conta = new Conta();
        conta.setTipo((short) TipoConta.CC.getChave());
        conta.setBanco((short) Banco.SANTANDER.getChave());
        conta.setNumeroConta("9000");
        conta.setAgencia("0110");
        conta.setIdUsuario(usuario.getId());

        ContaService contaService = new ContaService(conta);
        contaService.salvar();
    }
}
