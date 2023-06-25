package br.com.mba.engenharia.de.software.controller;

import br.com.mba.engenharia.de.software.negocio.role.RoleRepository;
import br.com.mba.engenharia.de.software.negocio.users.Users;
import br.com.mba.engenharia.de.software.negocio.users.UserRepository;
import br.com.mba.engenharia.de.software.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UserController {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Secured({Const.ROLE_ADMIN})
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Users> save(@RequestBody Users user){
        user = this.userRepository.save(user);
        return new ResponseEntity<Users>(user, HttpStatus.OK);
    }

    @Secured({Const.ROLE_ADMIN})
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<Users> edit(@RequestBody Users user){
        user = this.userRepository.save(user);
        return new ResponseEntity<Users>(user, HttpStatus.OK);
    }

    @Secured({Const.ROLE_CLIENT, Const.ROLE_ADMIN})
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Page<Users>> list(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ){
        Pageable pageable = PageRequest.of(page, size, Sort.by("name"));
        return new ResponseEntity<Page<Users>>(userRepository.findAll(pageable), HttpStatus.OK);
    }


}
