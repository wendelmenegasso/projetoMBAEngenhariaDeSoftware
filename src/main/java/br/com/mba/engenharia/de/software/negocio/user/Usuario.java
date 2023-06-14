package br.com.mba.engenharia.de.software.negocio.user;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario extends AbstractPersistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Long idUsuario;
    @Column(name = "usuario", length = 30, nullable = false, unique = true)
    private String nome;
    @Column(name = "senha", length = 100, nullable = false, unique = false)
    private String senha;
    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;
    @Column(name="token", length = 200, nullable = false, unique = true)
    private String token;

    public Usuario(Long idUsuario, String nome, String senha, String email, String token){
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.token = token;
    }

    public Usuario(){

    }

    public Long getId() {
        return idUsuario;
    }

    public void setId(long id) {
        this.idUsuario = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
