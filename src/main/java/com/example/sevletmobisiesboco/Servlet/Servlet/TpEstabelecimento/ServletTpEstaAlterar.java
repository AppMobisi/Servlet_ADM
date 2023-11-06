package com.example.sevletmobisiesboco.Servlet.Servlet.TpEstabelecimento;

import com.example.sevletmobisiesboco.Servlet.CRUD.TpDeficiencia;
import com.example.sevletmobisiesboco.Servlet.CRUD.TpEstabelecimento;
import com.example.sevletmobisiesboco.Servlet.Tabela.TpDeficienciaObj;
import com.example.sevletmobisiesboco.Servlet.Tabela.TpEstabelecimentoObj;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletTpEstaAlterar", value = "/Entrada/TpEstabelecimento/alterarTpEst")
public class ServletTpEstaAlterar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        TpEstabelecimento tpEstabelecimento = new TpEstabelecimento();
        try{
            //Passando os parâmetros e transformando os valores
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");

            //Executando o método
            int resultado = tpEstabelecimento.alterar(new TpEstabelecimentoObj(nome),id);
            //Retornando a mensagem para o usuário
            System.out.println(resultado);
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
