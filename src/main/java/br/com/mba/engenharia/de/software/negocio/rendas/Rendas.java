package br.com.mba.engenharia.de.software.negocio.rendas;

import br.com.mba.engenharia.de.software.negocio.repeticao.Repeticao;
import br.com.mba.engenharia.de.software.negocio.usuarios.Usuarios;
import jakarta.persistence.*;

@Entity
@Table(name = "rendas")
public class Rendas {
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
    private TipoRenda tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repeticao")
    private Repeticao repeticao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario")
    private Usuarios usuario;

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Repeticao getRepeticao() {
        return repeticao;
    }

    public void setRepeticao(Repeticao repeticao) {
        this.repeticao = repeticao;
    }

    public TipoRenda getTipo() {
        return tipo;
    }

    public void setTipo(TipoRenda tipo) {
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