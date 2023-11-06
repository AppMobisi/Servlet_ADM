package com.example.sevletmobisiesboco.Servlet.Servlet.EstabelecimentoFv;

import com.example.sevletmobisiesboco.Servlet.CRUD.Estabelecimento;
import com.example.sevletmobisiesboco.Servlet.CRUD.EstabelecimentoFv;
import com.example.sevletmobisiesboco.Servlet.Tabela.EstabelecimentoFvObj;
import com.example.sevletmobisiesboco.Servlet.Tabela.EstabelecimentoObj;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletEstaFVInserir", value = "/Entrada/EstabelecimentoFv/inserirEstFv")
public class ServletEstaFVInserir extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //Passando os parâmetros
            int idEstabelecimento = Integer.parseInt(request.getParameter("idEstabelecimento"));
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

            //Criando o objeto das classes
            EstabelecimentoFv estabelecimentoFvCrud = new EstabelecimentoFv();
            EstabelecimentoFvObj estabelecimentoFvObj = new EstabelecimentoFvObj(idUsuario, idEstabelecimento);

            //Executando o método
            int resultado = estabelecimentoFvCrud.inserir(estabelecimentoFvObj);
            //Retornando a mensagem para o usuário
            if (resultado >= 1) {
                request.getRequestDispatcher("../../Retorno/Certo/inserir.html").forward(request, response);
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
        request.getRequestDispatcher("../../Retorno/Certo/inserir.html").forward(request, response);
    }
}
