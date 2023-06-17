package br.com.mba.engenharia.de.software.negocio.account;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "contasbanco")
public class Contas extends AbstractPersistable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.TABLE,
            generator = "tabela_id_contas"
    )
    @TableGenerator(
            name =  "tabela_id_contas",
            table = "ids_contas"
    )
    private Integer id;

    @Column(name = "banco")
    private Integer banco;

    @Column(name = "tipo")
    private Integer tipo;

    @Column(name = "saldo")
    private Double saldo;

    @Column(name = "agencia", length = 12)
    private String agencia;

    @Column(name = "conta", length = 12)
    private String conta;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}