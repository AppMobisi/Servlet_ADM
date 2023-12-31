package com.example.sevletmobisiesboco.Servlet.Servlet.Formulario;

import com.example.sevletmobisiesboco.Servlet.CRUD.Estabelecimento;
import com.example.sevletmobisiesboco.Servlet.CRUD.Formulario;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Normalizer;

@WebServlet(name = "ServletFormBuscarCampo", value = "/Entrada/Formulario/buscarCampo")
public class ServletFormBuscarCampo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //Passando os parâmetros
            String campo = request.getParameter("frequencia");
            String parametro = request.getParameter("parametro");
            //Criando o objeto das classes
            Formulario formularioCrud = new Formulario();
            //Executando o método e verificando os tipos dos parâmetros
            ResultSet resultado;
            try {
                resultado = formularioCrud.buscarCampo(Integer.parseInt(parametro), campo);
            } catch (NumberFormatException nop) {
                try {
                    resultado = formularioCrud.buscarCampo(Double.parseDouble(parametro), campo);
                } catch (NumberFormatException no) {
                    resultado = formularioCrud.buscarCampo(parametro, campo);
                }
            }

            //Retornando a mensagem para o usuário
            if (resultado == null){
                request.getRequestDispatcher("../../Retorno/Erro/erroBd.html").forward(request, response);
            }
            if (resultado.isBeforeFirst()) {
                request.setAttribute("resultado", resultado);
                request.getRequestDispatcher("../../Retorno/Certo/BuscarCampoForm.jsp").forward(request, response);
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
