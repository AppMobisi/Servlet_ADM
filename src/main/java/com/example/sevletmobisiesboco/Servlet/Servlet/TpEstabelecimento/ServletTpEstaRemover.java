package com.example.sevletmobisiesboco.Servlet.Servlet.TpEstabelecimento;

import com.example.sevletmobisiesboco.Servlet.CRUD.EstabelecimentoFv;
import com.example.sevletmobisiesboco.Servlet.CRUD.TpEstabelecimento;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletTpEstaRemover", value = "/Entrada/TpEstabelecimento/removerTpEst")
public class ServletTpEstaRemover extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String campo = request.getParameter("escolha");
            String  parametro = request.getParameter("parametro");
            //Criando o objeto da classe
            TpEstabelecimento tpEstabelecimentoCrud = new TpEstabelecimento();

            //Passando os parâmetros e executando o método
            int resultado;
            try {
                resultado = tpEstabelecimentoCrud.remover(campo, Integer.parseInt(parametro));
            }catch (NumberFormatException nf){
                resultado = tpEstabelecimentoCrud.remover(campo, parametro);
            }
            
            //Retornando a mensagem para o usuário
            if (resultado >= 1) {
                request.getRequestDispatcher("../../Retorno/Certo/remover.html").forward(request, response);
            } else {
                if (resultado == 0) {
                    request.getRequestDispatcher("../../Retorno/Erro/erroBd.html").forward(request, response);
                } else {
                    request.getRequestDispatcher("../../Retorno/Erro/erroJava.html").forward(request, response);
                }
            }
        } catch (NumberFormatException nfe) {
            request.getRequestDispatcher("../../Retorno/Erro/erroJava.html").forward(request, response);
        }
    }
}
