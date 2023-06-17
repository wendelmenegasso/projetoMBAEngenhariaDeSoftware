package br.com.mba.engenharia.de.software.negocio.rendas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tiporenda")
public class TipoRenda {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "descr", length = 50)
    private String descr;

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}