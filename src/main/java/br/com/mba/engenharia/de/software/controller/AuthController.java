package br.com.mba.engenharia.de.software.controller;

import br.com.mba.engenharia.de.software.negocio.users.Users;
import br.com.mba.engenharia.de.software.utils.Const;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthController{

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    @Secured({Const.ROLE_CLIENT, Const.ROLE_ADMIN})
    public Users userAuth() {
        return (Users) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
    }
}


