package br.com.mba.engenharia.de.software.service;

import br.com.mba.engenharia.de.software.model.database.CRUD;
import br.com.mba.engenharia.de.software.negocio.account.Conta;

public class ContaService implements CRUD {
    private Conta conta;
    public ContaService(Conta conta){
        this.conta = conta;
    }

    @Override
    public void salvar() {
        System.out.println(conta);
    }

    @Override
    public void consultar() {

    }

    @Override
    public void alterar() {

    }

    @Override
    public void deletar() {

    }
}
