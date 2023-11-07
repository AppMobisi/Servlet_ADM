package com.example.sevletmobisiesboco.Servlet.Servlet.Estabelecimento;

import com.example.sevletmobisiesboco.Servlet.CRUD.Estabelecimento;
import com.example.sevletmobisiesboco.Servlet.Tabela.EstabelecimentoObj;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletEstabelecimentoRemover", value = "/Entrada/Estabelecimento/removerEst")
public class ServletEstabelecimentoRemover extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //Criando o objeto da classe
            Estabelecimento estabelecimentoCrud = new Estabelecimento();
            int resultado = -2;
            //Passando os parâmetros e executando o método
            String parametro = request.getParameter("frequencia");
            String campo = request.getParameter("campo");
            try{
               resultado = estabelecimentoCrud.remover(campo, Integer.parseInt(request.getParameter("parametro")));
            }catch(NumberFormatException n){
                try{
                    resultado = estabelecimentoCrud.remover(campo, Double.parseDouble(request.getParameter("parametro")));
                }catch(NumberFormatException ne){
                    resultado = estabelecimentoCrud.remover(campo, request.getParameter("parametro"));
                }

            }
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
        request.getRequestDispatcher("../../Retorno/Certo/remover.html").forward(request, response);
    }
}
