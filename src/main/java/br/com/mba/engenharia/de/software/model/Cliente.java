package br.com.mba.engenharia.de.software.model;

import br.com.mba.engenharia.de.software.negocio.contas.Contas;
import org.springframework.stereotype.Component;

@Component
public class Cliente {

    private Contas account;

    public Contas getAccount() {
        return account;
    }

    public void setAccount(Contas account) {
        this.account = account;
    }
}