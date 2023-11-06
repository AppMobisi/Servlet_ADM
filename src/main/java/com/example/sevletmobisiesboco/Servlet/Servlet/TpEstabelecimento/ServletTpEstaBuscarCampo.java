package com.example.sevletmobisiesboco.Servlet.Servlet.TpEstabelecimento;

import com.example.sevletmobisiesboco.Servlet.CRUD.Estabelecimento;
import com.example.sevletmobisiesboco.Servlet.CRUD.TpEstabelecimento;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "ServletTpEstaBuscarCampo", value = "/Entrada/TpEstabelecimento/buscarCampoTpEst")
public class ServletTpEstaBuscarCampo extends HttpServlet {
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
            TpEstabelecimento tpEstabelecimentoCrud = new TpEstabelecimento();
            //Executando o método e verificando os tipos dos valores
            ResultSet resultado;
            try {
                resultado = tpEstabelecimentoCrud.buscarCampo(Integer.parseInt(parametro), campo);
            } catch (NumberFormatException nop) {
                try {
                    resultado = tpEstabelecimentoCrud.buscarCampo(Double.parseDouble(parametro), campo);
                } catch (NumberFormatException no) {
                    resultado = tpEstabelecimentoCrud.buscarCampo(parametro, campo);
                }
            }
            //Retornando a mensagem para o usuário
            if (resultado == null){
                request.getRequestDispatcher("../../Retorno/Erro/erroBd.html").forward(request, response);
            }
            if (resultado.isBeforeFirst()) {
                request.setAttribute("resultado", resultado);
                request.getRequestDispatcher("../../Retorno/Certo/BuscarCampoTpEst.jsp").forward(request, response);
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
