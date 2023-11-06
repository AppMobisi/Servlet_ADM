package com.example.sevletmobisiesboco.Servlet.Servlet.Formulario;

import com.example.sevletmobisiesboco.Servlet.CRUD.Estabelecimento;
import com.example.sevletmobisiesboco.Servlet.CRUD.Formulario;
import com.example.sevletmobisiesboco.Servlet.Tabela.EstabelecimentoObj;
import com.example.sevletmobisiesboco.Servlet.Tabela.FormularioObj;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletFormsInserir", value = "/Entrada/Formulario/inserirForm")
public class ServletFormInserir extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //Passando os parâmetros
            int iRampa = Integer.parseInt(request.getParameter("irampa"));
            int iCorrimao = Integer.parseInt(request.getParameter("icorrimao"));
            int iBanheiro = Integer.parseInt(request.getParameter("ibanheiro"));
            int iVagaPreferencial = Integer.parseInt(request.getParameter("ivagaPreferencial"));
            int Fk_Estabelecimento_iId = Integer.parseInt(request.getParameter("Fk_Estabelecimento_iId"));
            int Fk_usuario_iId = Integer.parseInt(request.getParameter("Fk_usuario_iId"));

            //Criando o objeto das classes
            Formulario formulario = new Formulario();
            FormularioObj formularioObj = new FormularioObj(Fk_Estabelecimento_iId, Fk_usuario_iId, iRampa, iCorrimao, iBanheiro, iVagaPreferencial);

            //Retornando a mensagem para o usuário
            int resultado = formulario.inserir(formularioObj);
            if (resultado >= 1) {
                request.getRequestDispatcher("../../Retorno/Certo/inserir.html").forward(request, response);
            } else {
                if (resultado == 0) {
                    request.getRequestDispatcher("../../Retorno/Erro/erroJava.html").forward(request, response);
                } else {
                    request.getRequestDispatcher("../../Retorno/Erro/erroBd.html").forward(request, response);
                }
            }
        } catch (NumberFormatException nfe) {
            request.getRequestDispatcher("../../Retorno/Erro/erroJava.html").forward(request, response);
        }


    }
}
