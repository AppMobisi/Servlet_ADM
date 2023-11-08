package com.example.sevletmobisiesboco.Servlet.Servlet.AnaliseDeDados;

import com.example.sevletmobisiesboco.Servlet.CRUD.AnaliseDeDados;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "ServletDeficienciaFvEsta", value = "/Entrada/AnaliseDeDados/buscarEstPorDefFv")
public class ServletDeficienciaFvEsta extends HttpServlet {
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
            //Executando o método e verificando os tipos dos parâmetros()
            ResultSet resultado;
            resultado = analiseDeDados.deficienciaFvEstabelecimento(Integer.parseInt(parametro));
            //Retornando a mensagem para o usuário
            if (resultado == null){
                System.out.println(1);
                request.getRequestDispatcher("../../Retorno/Erro/erroBd.html").forward(request, response);
            }
            if (resultado.isBeforeFirst()) {
                request.setAttribute("resultado", resultado);
                request.getRequestDispatcher("../../Entrada/AnaliseDeDados/DeficienciaFvEsta.jsp").forward(request, response);
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
