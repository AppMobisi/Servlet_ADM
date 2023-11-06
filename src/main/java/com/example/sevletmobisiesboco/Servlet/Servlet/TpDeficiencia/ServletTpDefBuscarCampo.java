package com.example.sevletmobisiesboco.Servlet.Servlet.TpDeficiencia;


import com.example.sevletmobisiesboco.Servlet.CRUD.TpDeficiencia;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "ServletTpDefBuscarCampo", value = "/Entrada/TpDeficiencia/buscarCampoTpDef")
public class ServletTpDefBuscarCampo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //Passando os parâmetros
            String campo = request.getParameter("campo");
            String parametro = request.getParameter("parametro");
            //Criando o objeto da classe
            TpDeficiencia tpDeficiencia = new TpDeficiencia();
            ResultSet resultado;
            //Executando o método e verificando os tipos dos valores
            try {
                resultado = tpDeficiencia.buscarCampo(Integer.parseInt(parametro), campo);
            } catch (NumberFormatException nop) {
                try {
                    resultado = tpDeficiencia.buscarCampo(Double.parseDouble(parametro), campo);
                } catch (NumberFormatException no) {
                    resultado = tpDeficiencia.buscarCampo(parametro, campo);
                }
            }
            //Retornando a mensagem para usuário
            if (resultado.isBeforeFirst()) {
                request.setAttribute("resultado", resultado);
                request.getRequestDispatcher("../../Retorno/Certo/BuscarCampoTpDef.jsp").forward(request, response);
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

