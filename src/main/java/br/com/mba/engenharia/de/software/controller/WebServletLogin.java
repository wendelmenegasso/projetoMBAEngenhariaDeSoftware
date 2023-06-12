package br.com.mba.engenharia.de.software.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/home/")
public class WebServletLogin extends HttpServlet {
    public WebServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void service(HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.getWriter();
        request.setAttribute("/testLogin",new LoginController().testLogin(request,response));
        request.setAttribute("/testConta",new ContaController().testConta(request,response));
        request.setAttribute("/logout", new LoginController().logout());
    }
}
