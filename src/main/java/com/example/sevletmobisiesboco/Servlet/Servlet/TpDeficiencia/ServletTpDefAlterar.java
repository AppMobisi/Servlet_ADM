package com.example.sevletmobisiesboco.Servlet.Servlet.TpDeficiencia;

import com.example.sevletmobisiesboco.Servlet.CRUD.Formulario;
import com.example.sevletmobisiesboco.Servlet.CRUD.TpDeficiencia;
import com.example.sevletmobisiesboco.Servlet.Tabela.FormularioObj;
import com.example.sevletmobisiesboco.Servlet.Tabela.TpDeficienciaObj;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletTpDefAlterar", value = "/Entrada/TpDeficiencia/alterarTpDef")
public class ServletTpDefAlterar extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        //Criando o objeto da classe
        TpDeficiencia tpDeficiencia = new TpDeficiencia();
        try{
            //Passando os parâmetros
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            //Executando o método
            int resultado = tpDeficiencia.alterar(new TpDeficienciaObj(nome),id);
            //Retornando a mensagem para o usuário
            if(resultado >= 1){
                request.getRequestDispatcher("../../Retorno/Certo/alterar.html").forward(request, response);
            }else{
                if(resultado == 0){
                    request.getRequestDispatcher("../../Retorno/Erro/erroBd.html").forward(request, response);
                }else{
                    request.getRequestDispatcher("../../Retorno/Erro/erroJava.html").forward(request, response);
                }
            }
        }catch (NumberFormatException nfe){
            request.getRequestDispatcher("../../Retorno/Erro/erroJava.html").forward(request, response);
        }
    }
}