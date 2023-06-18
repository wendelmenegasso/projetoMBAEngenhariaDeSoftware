package br.com.mba.engenharia.de.software.negocio.contas;

import br.com.mba.engenharia.de.software.negocio.usuarios.Usuarios;
import jakarta.persistence.*;

@Entity
@Table(name = "conta")
public class Contas  {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_banco")
    private Banco banco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_tipo")
    private Tipoconta tipo;

    @Column(name = "saldo")
    private Double saldo;

    @Column(name = "agencia", length = 12)
    private String agencia;

    @Column(name = "conta", length = 12)
    private String conta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_conta_usuario")
    private Usuarios usuario;

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
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

    public Tipoconta getTipo() {
        return tipo;
    }

    public void setTipo(Tipoconta tipo) {
        this.tipo = tipo;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}