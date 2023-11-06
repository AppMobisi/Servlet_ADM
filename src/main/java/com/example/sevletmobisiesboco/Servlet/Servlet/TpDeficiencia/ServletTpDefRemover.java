package com.example.sevletmobisiesboco.Servlet.Servlet.TpDeficiencia;

import com.example.sevletmobisiesboco.Servlet.CRUD.TpDeficiencia;
import com.example.sevletmobisiesboco.Servlet.Tabela.TpDeficienciaObj;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletTpDefRemover", value = "/Entrada/TpDeficiencia/tpDefRemoved")
public class ServletTpDefRemover extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //Passando os parâmetros
            String campo = request.getParameter("campo");
            String parametro = request.getParameter("parametro");

            //Criando o objeto das classe
            TpDeficiencia tpDeficiencia = new TpDeficiencia();

            //Executando e verificando o tipo dos parâmetros
            int resultado;
            try {
                resultado = tpDeficiencia.remover(campo, Integer.parseInt(parametro));
            } catch (NumberFormatException nfe) {
                resultado = tpDeficiencia.remover(campo, parametro);
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
    }
}
