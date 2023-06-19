package br.com.mba.engenharia.de.software.controller;

import br.com.mba.engenharia.de.software.UsuarioTeste;
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
        UsuarioTeste usuarioTeste = new UsuarioTeste();
    }

    public boolean cadastrarConta(Conta conta){
        UsuarioTeste usuarioTeste = new UsuarioTeste();
        return usuarioTeste.salvarConta(conta);
    }

    public List<Conta> consultarConta(Conta conta){
        UsuarioTeste usuarioTeste = new UsuarioTeste();
        return usuarioTeste.listarTodasContas(conta);
    }

}
