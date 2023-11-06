package com.example.sevletmobisiesboco.Servlet.Servlet.Estabelecimento;

import com.example.sevletmobisiesboco.Servlet.CRUD.Estabelecimento;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "ServletEstabelecimentoBuscarCampo", value = "/Entrada/Estabelecimento/buscarCampoEst")
public class ServletEstabelecimentoBuscarCampo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //Passando os parâmetros
            String campo = request.getParameter("campo");
            String parametro = request.getParameter("parametro");
            //Criando o objeto das classes
            Estabelecimento estabelecimentoCrud = new Estabelecimento();
            //Executando o método e verificando os tipos dos parâmetros
            ResultSet resultado;
            try {
                resultado = estabelecimentoCrud.buscarCampo(Integer.parseInt(parametro), campo);
            } catch (NumberFormatException nop) {
                try {
                    resultado = estabelecimentoCrud.buscarCampo(Double.parseDouble(parametro), campo);
                } catch (NumberFormatException no) {
                    resultado = estabelecimentoCrud.buscarCampo(parametro, campo);
                }
            }

            //Retornando a mensagem para o usuário
            if (resultado.isBeforeFirst()) {
                request.setAttribute("resultado", resultado);
                request.getRequestDispatcher("../../Retorno/Certo/BuscarCampoEst.jsp").forward(request, response);
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

