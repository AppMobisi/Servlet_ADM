
package com.example.sevletmobisiesboco.Servlet.Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletLogin", value = "/login")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String senha = request.getParameter("senha");
        if(senha.equals("mobisi123")){
            request.getRequestDispatcher("/adm.html").forward(request, response);
        }else{
            request.getRequestDispatcher("/Retorno/Erro/erroSenha.html").forward(request, response);
        }

    }
}