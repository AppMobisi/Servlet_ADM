package com.example.sevletmobisiesboco.Servlet.Servlet.TpDeficiencia;

import com.example.sevletmobisiesboco.Servlet.CRUD.TpDeficiencia;
import com.example.sevletmobisiesboco.Servlet.Tabela.TpDeficienciaObj;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletTpDefAlterarId", value = "/Entrada/TpDeficiencia/alterarIdTpDef")
public class ServletTpDefAlterarId extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Criando o objeto da classe do crud
        TpDeficiencia tpDeficiencia = new TpDeficiencia();
        HttpSession session = request.getSession();
        try{
            //Passando os parâmetros
            int id = Integer.parseInt(request.getParameter("id"));
            //Criando o objeto da classe
            TpDeficienciaObj tpDeficienciaObj = tpDeficiencia.BuscarInformacao(id);
            //Verificando se as informações estão alteradas
            if(tpDeficienciaObj != null) {
                //Transformando os valores dos parâmetros
                request.setAttribute("id", id);
                request.setAttribute("nome", tpDeficienciaObj.getcNome());
                //Retornando a mensagem para o usuário
                request.getRequestDispatcher("alterarTpDef.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("../../Retorno/Erro/erroId.html").forward(request, response);
            }
        }catch (NumberFormatException nfe){
            request.getRequestDispatcher("/Retorno/Erro/erroJava.html").forward(request, response);
        }
    }
}
