package br.com.mba.engenharia.de.software.negocio.account;

import java.math.BigDecimal;

public interface Account {
    BigDecimal getValue(String accountNumber, String accountAgency);
    boolean setValue(String accountNumber, String accountAgency,double value);
    boolean createAccount(String firstName, String secondName, String cpf, String rg, BigDecimal salary, String street,
    String cep, String city, String country);
    boolean findAccount(String accountNumber, String accountAgency);
}
