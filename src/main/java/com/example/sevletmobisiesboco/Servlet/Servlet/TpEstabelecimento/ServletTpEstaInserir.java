package com.example.sevletmobisiesboco.Servlet.Servlet.TpEstabelecimento;

import com.example.sevletmobisiesboco.Servlet.CRUD.TpDeficiencia;
import com.example.sevletmobisiesboco.Servlet.CRUD.TpEstabelecimento;
import com.example.sevletmobisiesboco.Servlet.Tabela.TpDeficienciaObj;
import com.example.sevletmobisiesboco.Servlet.Tabela.TpEstabelecimentoObj;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletTpEstaInserir", value = "/Entrada/TpEstabelecimento/inserirTpEst")
public class ServletTpEstaInserir extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //Passando os parâmetros
            String nome = request.getParameter("cnome");

            //Criando os objetos das classes
            TpEstabelecimento tpEstabelecimentoCrud = new TpEstabelecimento();
            TpEstabelecimentoObj tpEstabelecimentoObj = new TpEstabelecimentoObj(nome);

            //Chamando o método
            int resultado= tpEstabelecimentoCrud.inserir(tpEstabelecimentoObj);
            //Retornando a mensagem pro usuario
            if (resultado >= 1){
                request.getRequestDispatcher("../../Retorno/Certo/inserir.html").forward(request, response);
            }
            else if (resultado == 0){
                request.getRequestDispatcher("../../Retorno/Erro/erroJava.html").forward(request, response);
            }
            else{
                request.getRequestDispatcher("../../Retorno/Erro/erroBd.html").forward(request, response);
            }
        }
        catch (NumberFormatException e){
            request.getRequestDispatcher("../../Retorno/Erro/erroJava.html").forward(request, response);
        }
    }
}
