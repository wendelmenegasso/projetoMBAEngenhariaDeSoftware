package br.com.mba.engenharia.de.software.controller;

import br.com.mba.engenharia.de.software.service.ContaService;
import br.com.mba.engenharia.de.software.negocio.contas.Conta;
import br.com.mba.engenharia.de.software.negocio.usuarios.Usuario;

import java.util.List;

public class Controller {
    private Usuario usuario;
    public Controller(Usuario usuario){
        this.usuario = usuario;
    }

    public Controller(){
    }

    public void cadastrarUsuario(){
        ContaService contaService = new ContaService();
    }

    public boolean cadastrarConta(Conta conta){
        ContaService contaService = new ContaService();
        return contaService.salvarConta(conta);
    }

    public List<Conta> consultarConta(Conta conta){
        ContaService contaService = new ContaService();
        return contaService.listarConta(conta);
    }

}
