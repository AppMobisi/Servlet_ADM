package com.example.sevletmobisiesboco.Servlet.Servlet.AnaliseDeDados;

import com.example.sevletmobisiesboco.Servlet.CRUD.AnaliseDeDados;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "ServletAnaliseEstaDefAcessivel", value = "/Entrada/AnaliseDeDados/buscarEstPorDef")
public class ServletAnaliseEstaDefAcessivel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //Passando os parâmetros
            String parametro = request.getParameter("parametro");
            //Criando o objeto das classes
            AnaliseDeDados analiseDeDados = new AnaliseDeDados();
            //Executando o método e verificando os tipos dos parâmetros
            ResultSet resultado = analiseDeDados.estabelecimentoDefAcessivel(parametro);
            //Retornando a mensagem para o usuário
            if (resultado == null){
                request.getRequestDispatcher("../../Retorno/Erro/erroBd.html").forward(request, response);
            }
            if (resultado.isBeforeFirst()) {
                request.setAttribute("resultado", resultado);
                request.getRequestDispatcher("../../Entrada/AnaliseDeDados/EstabelecimentoDefAcessivel.jsp").forward(request, response);
            }else {
                request.getRequestDispatcher("../../Retorno/Erro/erroBd.html").forward(request, response);
            }

        } catch (NumberFormatException nfe) {
            request.getRequestDispatcher("../../Retorno/Erro/erroJava.html").forward(request, response);
        }catch (SQLException erro) {
            request.getRequestDispatcher("../../Retorno/Erro/erroBd.html").forward(request, response);

        }
    }
}
