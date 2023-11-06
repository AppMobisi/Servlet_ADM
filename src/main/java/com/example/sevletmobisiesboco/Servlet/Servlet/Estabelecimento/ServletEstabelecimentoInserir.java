package com.example.sevletmobisiesboco.Servlet.Servlet.Estabelecimento;

import com.example.sevletmobisiesboco.Servlet.CRUD.Estabelecimento;
import com.example.sevletmobisiesboco.Servlet.Tabela.EstabelecimentoObj;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletEstabelecimento", value = "/Entrada/Estabelecimento/inserirEst")
public class ServletEstabelecimentoInserir extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //Passando os parâmetros
            String nome = request.getParameter("nome");
            double nota = Double.parseDouble(request.getParameter("nota"));
            int cep = Integer.parseInt(request.getParameter("cep"));
            String rua = request.getParameter("rua");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            int itpestabelecimento = Integer.parseInt(request.getParameter("tpEstabelecimento"));

            //Criando os objetos das classes
            Estabelecimento estabelecimentoCrud = new Estabelecimento();
            EstabelecimentoObj estabelecimentoObj = new EstabelecimentoObj(nome, nota, cep, rua, cidade, estado, itpestabelecimento);

            //Retornando a mensagem para o usuário
            int resultado = estabelecimentoCrud.inserir(estabelecimentoObj);
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

    }
}

