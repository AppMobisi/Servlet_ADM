package com.example.sevletmobisiesboco.Servlet.Servlet.Formulario;

import com.example.sevletmobisiesboco.Servlet.CRUD.Estabelecimento;
import com.example.sevletmobisiesboco.Servlet.CRUD.EstabelecimentoFv;
import com.example.sevletmobisiesboco.Servlet.CRUD.Formulario;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletFormRemover", value = "/Entrada/Formulario/removerForm")
public class ServletFormRemover extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //Passando os parâmetros
            String campo = request.getParameter("escolha");
            int  parametro = Integer.parseInt(request.getParameter("parametro"));
            //Criando o objeto das classes
            Formulario formularioCrud = new Formulario();
            //Executando o método
            int resultado = formularioCrud.remover(campo, parametro);
            System.out.println(resultado);
            //Retornando a mensagem para o usuário
            if (resultado >= 1) {
                request.getRequestDispatcher("../../Retorno/Certo/remover.html").forward(request, response);
            } else {
                if (resultado == 0) {
                    request.getRequestDispatcher("../../Retorno/Erro/erroJava.html").forward(request, response);
                } else {
                    request.getRequestDispatcher("../../Retorno/Erro/erroBd.html").forward(request, response);
                }
            }
        } catch (NumberFormatException nfe) {
            request.getRequestDispatcher("../../Retorno/Erro/erroJava.html").forward(request, response);
        }

    }
}
