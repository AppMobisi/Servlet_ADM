package com.example.sevletmobisiesboco.Servlet.Servlet.Formulario;

import com.example.sevletmobisiesboco.Servlet.CRUD.Estabelecimento;
import com.example.sevletmobisiesboco.Servlet.CRUD.Formulario;
import com.example.sevletmobisiesboco.Servlet.Tabela.EstabelecimentoObj;
import com.example.sevletmobisiesboco.Servlet.Tabela.FormularioObj;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletFormAlterarId", value = "/Entrada/Formulario/alterarIdForm")
public class ServletFormAlterarId extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Criando o objeto da classe do crud
        Formulario formulario = new Formulario();
        try{
            //Passando o id como parâmetro
            int id = Integer.parseInt(request.getParameter("id"));
            //Criando o objeto da classe
            FormularioObj formularioObj = formulario.BuscarInformacao(id);
            //Verificando se as informações estão alteradas
            if(formularioObj != null) {
                //Transformando os valores dos parâmetros
                request.setAttribute("id", id);
                request.setAttribute("usuario", formularioObj.getFk_usuario_iId());
                request.setAttribute("idest", formularioObj.getFk_Estabelecimento_iId());
                request.setAttribute("rampa", formularioObj.getiRampa());
                request.setAttribute("corrimao", formularioObj.getiCorrimao());
                request.setAttribute("banheiro", formularioObj.getiBanheiro());
                request.setAttribute("vaga", formularioObj.getiVagaPreferencial());
                request.getRequestDispatcher("alterarForm.jsp").forward(request, response);
                //Retornando a mensagem para o usuário
            }else{
                request.getRequestDispatcher("../../Retorno/Erro/erroId.html").forward(request, response);
            }
        }catch (NumberFormatException nfe){
            request.getRequestDispatcher("/Retorno/Erro/erroJava.html").forward(request, response);
        }
    }
}
