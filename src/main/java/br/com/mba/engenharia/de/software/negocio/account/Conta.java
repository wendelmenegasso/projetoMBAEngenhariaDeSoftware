package br.com.mba.engenharia.de.software.negocio.account;

import java.math.BigDecimal;

public class Conta {
    private short tipo;
    private short banco;
    private String numeroConta;
    private String agencia;
    private BigDecimal saldo;
    private long idUsuario;

    public short getTipo() {
        return tipo;
    }

    public void setTipo(short tipo) {
        this.tipo = tipo;
    }

    public short getBanco() {
        return banco;
    }

    public void setBanco(short banco) {
        this.banco = banco;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }


}
