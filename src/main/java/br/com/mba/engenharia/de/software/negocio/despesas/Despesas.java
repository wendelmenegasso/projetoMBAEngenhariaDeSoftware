package br.com.mba.engenharia.de.software.negocio.despesas;

import br.com.mba.engenharia.de.software.negocio.rendas.Repeticao;
import jakarta.persistence.*;

@Entity
@Table(name = "despesas")
public class Despesas {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "mes")
    private Integer mes;

    @Column(name = "ano")
    private Integer ano;

    @Column(name = "dia")
    private Integer dia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo")
    private Tipodespesa tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repeticao")
    private Repeticao repeticao;

    @Column(name = "origem")
    private Integer origem;

    public Integer getOrigem() {
        return origem;
    }

    public void setOrigem(Integer origem) {
        this.origem = origem;
    }

    public Repeticao getRepeticao() {
        return repeticao;
    }

    public void setRepeticao(Repeticao repeticao) {
        this.repeticao = repeticao;
    }

    public Tipodespesa getTipo() {
        return tipo;
    }

    public void setTipo(Tipodespesa tipo) {
        this.tipo = tipo;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
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