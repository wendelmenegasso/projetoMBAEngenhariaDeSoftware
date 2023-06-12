package br.com.mba.engenharia.de.software.model;

import br.com.mba.engenharia.de.software.negocio.account.AccountImpl;
import org.springframework.stereotype.Component;

@Component
public class Cliente {

    private AccountImpl account;

    public AccountImpl getAccount() {
        return account;
    }

    public void setAccount(AccountImpl account) {
        this.account = account;
    }
}