package br.com.mba.engenharia.de.software.config;

import br.com.mba.engenharia.de.software.negocio.role.RoleRepository;
import br.com.mba.engenharia.de.software.negocio.users.Role;
import br.com.mba.engenharia.de.software.negocio.users.User;
import br.com.mba.engenharia.de.software.negocio.users.Users;
import br.com.mba.engenharia.de.software.negocio.users.UserRepository;
import br.com.mba.engenharia.de.software.security.Criptrografia;
import br.com.mba.engenharia.de.software.service.UsersService;
import br.com.mba.engenharia.de.software.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataIniatializir implements ApplicationListener<ContextRefreshedEvent> {

    UserRepository userRepository;

    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {

        UsersService usersService = new UsersService();
        List<User> usersList = usersService.listarTodosUsuarios();

        if (usersList.isEmpty()) {
            User users = new User();
            users.setName("admin");
            users.setEmail("admin@admin.com.br");
            Criptrografia criptrografia = new Criptrografia();
            Role role = new Role();
            role.setId(1);
            role.setName(Const.ROLE_ADMIN);
            users.setPassword(criptrografia.gerarHash("123456"));
            users.setRole(role.getId());
            usersService.salvarConta(users);

            User usersTwo = new User();
            usersTwo.setName("client");
            usersTwo.setEmail("client@client.com.br");
            Role roleTwo = new Role();
            roleTwo.setId(2);
            roleTwo.setName(Const.ROLE_CLIENT);
            usersTwo.setRole(roleTwo.getId());
            usersTwo.setPassword(criptrografia.gerarHash("123456"));
            usersService.salvarConta(usersTwo);
        }

    }

    public void createUser(String name, String email, String password, String roleName) {

//        Role role = new Role(roleName);
//
//        this.roleRepository.save(role);
//        Users user = new Users(name, email, password, Arrays.asList(role));
//        userRepository.save(user);
    }

}
