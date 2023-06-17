package br.com.mba.engenharia.de.software.controller;

import br.com.mba.engenharia.de.software.UsuarioTeste;
import br.com.mba.engenharia.de.software.negocio.contas.Contas;
import br.com.mba.engenharia.de.software.negocio.usuarios.Usuarios;

public class Controller {
    private Usuarios usuario;
    public Controller(Usuarios usuario){
        this.usuario = usuario;
    }

    public void cadastrarUsuario(){
        UsuarioTeste usuarioTeste = new UsuarioTeste();
    }

    public boolean cadastrarConta(Contas conta){
        UsuarioTeste usuarioTeste = new UsuarioTeste();
        return usuarioTeste.salvarConta(conta);
    }

}
