package br.com.mba.engenharia.de.software.negocio.empresas;

import br.com.mba.engenharia.de.software.negocio.usuarios.Usuarios;
import jakarta.persistence.*;

@Entity
@Table(name = "empresa")
public class Empresas {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "cnpj", length = 14)
    private String cnpj;

    @Column(name = "ie", length = 14)
    private String ie;

    @Column(name = "numeroFuncionarios")
    private Integer numeroFuncionarios;

    @Column(name = "nomeFantasia", length = 50)
    private String nomeFantasia;

    @Column(name = "faturamento")
    private Double faturamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario")
    private Usuarios usuario;

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Double getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(Double faturamento) {
        this.faturamento = faturamento;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public Integer getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    public void setNumeroFuncionarios(Integer numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}