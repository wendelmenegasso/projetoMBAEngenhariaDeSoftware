package br.com.mba.engenharia.de.software.servlets;

import br.com.mba.engenharia.de.software.controller.UsuarioController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contaCadastradaComSucesso")
public class WebServletUsuario extends HttpServlet {
    public WebServletUsuario() {
        super();
    }

    protected void service(HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);

    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.getWriter();
        request.setAttribute("/enviarCadastro", new UsuarioController().enviarCadastro(request, response));
    }
}
