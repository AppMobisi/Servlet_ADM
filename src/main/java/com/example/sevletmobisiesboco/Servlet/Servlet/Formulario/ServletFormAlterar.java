package com.example.sevletmobisiesboco.Servlet.Servlet.Formulario;

import com.example.sevletmobisiesboco.Servlet.CRUD.Estabelecimento;
import com.example.sevletmobisiesboco.Servlet.CRUD.Formulario;
import com.example.sevletmobisiesboco.Servlet.Tabela.EstabelecimentoObj;
import com.example.sevletmobisiesboco.Servlet.Tabela.FormularioObj;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletFormAlterar", value = "/Entrada/Formulario/alterarForm")
public class ServletFormAlterar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        //Criando o objeto da classe
        Formulario formulario= new Formulario();
        try{
            //Passando os parâmetros
            int id = Integer.parseInt(request.getParameter("id"));
            int idUsuario = Integer.parseInt(request.getParameter("usuario"));
            int idEst = Integer.parseInt(request.getParameter("idest"));
            int irampa = Integer.parseInt(request.getParameter("rampa"));
            int icorrimao = Integer.parseInt(request.getParameter("corrimao"));
            int ibanheiro = Integer.parseInt(request.getParameter("banheiro"));
            int ivaga = Integer.parseInt(request.getParameter("vaga"));

            //Executando o método
            int resultado = formulario.alterar(new FormularioObj(irampa,icorrimao,ibanheiro,ivaga, idEst, idUsuario),id);
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
