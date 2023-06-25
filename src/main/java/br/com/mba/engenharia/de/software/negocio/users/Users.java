package br.com.mba.engenharia.de.software.negocio.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import br.com.mba.engenharia.de.software.negocio.role.Role;

import java.util.List;

@Entity
@Getter
@Setter
public class Users {

    @Id
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    @JsonIgnore
    private String password;

    private int roles;

    public Users() {
    }

    public Users(String name, String email) {
        super();
        this.name = name;
        this.email = email;
    }
    public Users(Users user) {
        super();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = user.getRoles();
        this.id = user.getId();
    }
    public Users(String name, String email, String password, int roles) {
        super();
        this.name = name;
        this.email = email;
        this.roles = roles;
        this.password = password;
    }

}

