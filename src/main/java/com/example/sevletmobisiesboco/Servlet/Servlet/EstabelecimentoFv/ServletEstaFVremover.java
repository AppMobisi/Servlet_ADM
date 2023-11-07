package com.example.sevletmobisiesboco.Servlet.Servlet.EstabelecimentoFv;

import com.example.sevletmobisiesboco.Servlet.CRUD.Estabelecimento;
import com.example.sevletmobisiesboco.Servlet.CRUD.EstabelecimentoFv;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "ServletEstaFVremover", value = "/Entrada/EstabelecimentoFv/removerEstFv")
public class ServletEstaFVremover extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //Passando os parâmetros
            String campo = request.getParameter("frequencia");
            int  parametro = Integer.parseInt(request.getParameter("parametro"));

            //Criando o objeto da classe
            EstabelecimentoFv estabelecimentoFv = new EstabelecimentoFv();

            //Retornando a mensagem para o usuário
            int resultado = estabelecimentoFv.remover(campo, parametro);
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
