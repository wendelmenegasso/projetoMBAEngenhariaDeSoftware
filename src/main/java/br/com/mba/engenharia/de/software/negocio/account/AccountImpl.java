package br.com.mba.engenharia.de.software.negocio.account;

import java.math.BigDecimal;

public class AccountImpl implements Account{

    @Override
    public BigDecimal getValue(String accountNumber, String accountAgency) {
        BigDecimal value;
        if(findAccount(accountNumber,accountAgency))value = new BigDecimal(("1100"));
        else {
            value = new BigDecimal("0");
        }
        return value;
    }

    @Override
    public boolean setValue(String accountNumber, String accountAgency, double value) {
        double sum =  value + Double.parseDouble(getValue(accountNumber,accountAgency).toString());
        BigDecimal valueInTheAccount = new BigDecimal(sum);
        return true;
    }

    @Override
    public boolean createAccount(String firstName, String secondName, String cpf, String rg,
                                 BigDecimal salary, String street, String cep, String city,
                                 String country) {
        return false;
    }

    @Override
    public boolean findAccount(String accountNumber, String accountAgency) {
        return true;
    }
}
