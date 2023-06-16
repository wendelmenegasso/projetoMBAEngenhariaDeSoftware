package br.com.mba.engenharia.de.software.negocio.user;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "usuario", length = 30, nullable = false, unique = true)
    private String nome;
    @Column(name = "senha", length = 100, nullable = false, unique = false)
    private String senha;
    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;
    @Column(name="token", length = 200, nullable = false, unique = true)
    private String token;

    public Usuario(String nome, String senha, String email, String token){
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.token = token;
    }

    public Usuario(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }


}
