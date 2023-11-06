package com.example.sevletmobisiesboco.Servlet.Servlet.TpDeficiencia;

import com.example.sevletmobisiesboco.Servlet.CRUD.Estabelecimento;
import com.example.sevletmobisiesboco.Servlet.CRUD.TpDeficiencia;
import com.example.sevletmobisiesboco.Servlet.Tabela.TpDeficienciaObj;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletTpDefInserir", value = "/Entrada/TpDeficiencia/inserirTpDef")
public class ServletTpDefInserir extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //Passando os parâmetros
            String nome = request.getParameter("cnome");

            //Criando os objetos das classes
            TpDeficiencia tpDeficienciaCrud = new TpDeficiencia();
            TpDeficienciaObj tpDeficienciaObj= new TpDeficienciaObj(nome);
            //Executando o método
            int resultado= tpDeficienciaCrud.inserir(tpDeficienciaObj);
            //Retornando a mensagem para o usuário
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
