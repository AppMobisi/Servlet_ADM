package com.example.sevletmobisiesboco.Servlet.Servlet.TpEstabelecimento;

import com.example.sevletmobisiesboco.Servlet.CRUD.TpEstabelecimento;
import com.example.sevletmobisiesboco.Servlet.Tabela.TpEstabelecimentoObj;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletTpEstAlterarId", value = "/Entrada/TpEstabelecimento/alterarIdTpEst")
public class ServletTpEstAlterarId extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Criando o objeto da classe do crud
        TpEstabelecimento tpEstabelecimento = new TpEstabelecimento();
        HttpSession session = request.getSession();
        try{
            //Passando o id como parâmetro
            int id = Integer.parseInt(request.getParameter("id"));
            //Criando o objeto da classe
            TpEstabelecimentoObj tpEstabelecimentoObj = tpEstabelecimento.BuscarInformacao(id);
            //Verificando se as informações estão alteradas
            if(tpEstabelecimentoObj != null) {
                //Transformando os valores dos parâmetros
                request.setAttribute("id", id);
                request.setAttribute("nome", tpEstabelecimentoObj.getcNome());
                //Retornando a mensagem para o usuário
                request.getRequestDispatcher("alterarTpEst.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("../../Retorno/Erro/erroId.html").forward(request, response);
            }
        }catch (NumberFormatException nfe){
            request.getRequestDispatcher("../../Retorno/Erro/erroJava.html").forward(request, response);
        }
    }
}
