package com.example.sevletmobisiesboco.Servlet.Servlet.EstabelecimentoFv;

import com.example.sevletmobisiesboco.Servlet.CRUD.EstabelecimentoFv;
import com.example.sevletmobisiesboco.Servlet.CRUD.TpEstabelecimento;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "ServletEstaFVBuscarCampo", value = "/Entrada/EstabelecimentoFv/buscarCampoEstFv")
public class ServletEstaFVBuscarCampo extends HttpServlet {
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
            EstabelecimentoFv estabelecimentoFvCrud = new EstabelecimentoFv();
            ResultSet resultado;
            //Executando o método e verificando o tipo dos parâmetros
            try {
                resultado = estabelecimentoFvCrud.buscarCampo(Integer.parseInt(parametro), campo);
            } catch (NumberFormatException nop) {
                try {
                    resultado = estabelecimentoFvCrud.buscarCampo(Double.parseDouble(parametro), campo);
                } catch (NumberFormatException no) {
                    resultado = estabelecimentoFvCrud.buscarCampo(parametro, campo);
                }
            }
            //Retornando a mensagem para o usuário
            if (resultado.isBeforeFirst()) {
                request.setAttribute("resultado", resultado);
                request.getRequestDispatcher("../../Retorno/Certo/BuscarCampoEstFv.jsp").forward(request, response);
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
