package br.com.mba.engenharia.de.software.controller;

import br.com.mba.engenharia.de.software.UsuarioTeste;
import br.com.mba.engenharia.de.software.negocio.account.Conta;
import br.com.mba.engenharia.de.software.negocio.user.Usuario;

public class Controller {
    private Usuario usuario;
    public Controller(Usuario usuario){
        this.usuario = usuario;
    }

    public void cadastrarUsuario(){
        UsuarioTeste usuarioTeste = new UsuarioTeste();
    }

    public boolean cadastrarConta(Conta conta){
        UsuarioTeste usuarioTeste = new UsuarioTeste();
        return usuarioTeste.salvarConta(conta);
    }

}
