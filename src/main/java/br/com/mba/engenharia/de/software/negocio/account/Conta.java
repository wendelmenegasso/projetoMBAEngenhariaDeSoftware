package br.com.mba.engenharia.de.software.negocio.account;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "conta")
public class Conta extends AbstractPersistable {
    @Id
    private Integer id;

    @Column(name = "banco", nullable = false)
    private Integer banco;

    @Column(name = "tipo", nullable = false)
    private Integer tipo;

    @Column(name = "saldo")
    private Double saldo;

    @Column(name = "agencia", length = 45)
    private String agencia;

    @Column(name = "conta", length = 45)
    private String conta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getBanco() {
        return banco;
    }

    public void setBanco(Integer banco) {
        this.banco = banco;
    }
}