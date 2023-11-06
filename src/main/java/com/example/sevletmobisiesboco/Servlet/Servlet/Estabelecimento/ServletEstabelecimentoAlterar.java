package com.example.sevletmobisiesboco.Servlet.Servlet.Estabelecimento;

import com.example.sevletmobisiesboco.Servlet.CRUD.Estabelecimento;
import com.example.sevletmobisiesboco.Servlet.Tabela.EstabelecimentoObj;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletEstabelecimentoAlterar", value = "/Entrada/Estabelecimento/alterarEst")
public class ServletEstabelecimentoAlterar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        //Criando o objeto da classe
        Estabelecimento estabelecimento = new Estabelecimento();
        try{
            //Passando os parâmetros
            String id = request.getParameter("id");
            String nome = request.getParameter("nome");
            String nota = request.getParameter("nota");
            String cep = request.getParameter("cep");
            String rua = request.getParameter("rua");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            String foto = request.getParameter("foto");
            String tpEst = request.getParameter("tpEst");

            //Executando o método
            int resultado = estabelecimento.alterar(new EstabelecimentoObj(nome,Double.parseDouble(nota),Integer.parseInt(cep),rua, cidade, estado, foto,Integer.parseInt( tpEst)),Integer.parseInt(id));
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
