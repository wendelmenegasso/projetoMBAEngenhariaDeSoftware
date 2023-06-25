package br.com.mba.engenharia.de.software.controller;

import br.com.mba.engenharia.de.software.negocio.users.Users;
import br.com.mba.engenharia.de.software.utils.Const;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

@Controller
public class SecurityController {

    @RequestMapping(value = "/user-auth", method = RequestMethod.GET)
    @ResponseBody
    @Secured({Const.ROLE_CLIENT, Const.ROLE_ADMIN})
    public Users user() {
        return (Users) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
    }

    @GetMapping("/error")
    public String error(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String message = (String) request.getSession().getAttribute("error.message");
        if (message == null){{
            response.getWriter().println("OK");
        }}
        request.getSession().removeAttribute("error.message");
        return message;
    }

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }

    @RequestMapping("/logout")
    public String logout(HttpServletResponse response) throws IOException {
        response.getWriter().println("Deslogado com sucesso");
        return "";
    }


}
