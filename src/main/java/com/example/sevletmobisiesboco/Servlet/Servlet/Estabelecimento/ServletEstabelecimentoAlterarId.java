package com.example.sevletmobisiesboco.Servlet.Servlet.Estabelecimento;

import com.example.sevletmobisiesboco.Servlet.CRUD.Estabelecimento;
import com.example.sevletmobisiesboco.Servlet.Tabela.EstabelecimentoObj;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
@WebServlet(name = "ServletEstabelecimentoAlterarId", value = "/Entrada/Estabelecimento/alterarIdEst")
public class ServletEstabelecimentoAlterarId extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Estabelecimento estabelecimento = new Estabelecimento();

        try{
            //Passando o id como parâmetro
            int id = Integer.parseInt(request.getParameter("id"));
            //Criando o objeto das classe
            EstabelecimentoObj estabelecimentoObj = estabelecimento.BuscarInformacao(id);
            //Verificando se as informações estão alteradas
            if(estabelecimentoObj != null) {
                //Passando os parâmetros e transformando os valores
                request.setAttribute("id", id);
                request.setAttribute("nome", estabelecimentoObj.getNome());
                request.setAttribute("nota", estabelecimentoObj.getNota());
                request.setAttribute("rua", estabelecimentoObj.getRua());
                request.setAttribute("cidade", estabelecimentoObj.getCidade());
                request.setAttribute("cep", estabelecimentoObj.getCep());
                request.setAttribute("estado", estabelecimentoObj.getEstado());
                request.setAttribute("tpEst", estabelecimentoObj.getFkTpEstabelecimento());
                //Retornando a mensagem para o usuário
                request.getRequestDispatcher("alterarEst.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("../../Retorno/Erro/erroId.html").forward(request, response);
            }
        }catch (NumberFormatException nfe){
            request.getRequestDispatcher("../../Retorno/Erro/erroJava.html").forward(request, response);
        }
    }

}

