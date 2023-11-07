package com.example.sevletmobisiesboco.Servlet.CRUD;

import com.example.sevletmobisiesboco.Servlet.Tabela.EstabelecimentoFvObj;

import java.sql.ResultSet;
import java.sql.SQLException;

//Criada em: 22/09/2023
//Classe Estabelecimento favorito, métodos CRUD da tabela Estabelecimento_fv

public class EstabelecimentoFv extends Conexao{


    //método para inserir dados da tabela
    public int inserir(EstabelecimentoFvObj estabelecimentoFvObj){
        conectar();//abrindo a conexão com o banco
        try {
            pstmt = conn.prepareStatement("INSERT INTO Estabelecimento_Favorito (iusuarioid, iestabelecimentoid) " +
                    "VALUES (?,?)");
            //Inserindo os parametros
            pstmt.setInt(1, estabelecimentoFvObj.getUsuarioId());
            pstmt.setInt(2, estabelecimentoFvObj.getEstabelecimentoId());
            return pstmt.executeUpdate();//executando o comando sql do preparedStatement
        }catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        }
        finally {
            desconectar();//fechando a conexão com o banco
        }

    }


    //método para remover dados da tabela
    public int remover(String campo, Object parametro){
        conectar();
        try{
            String remover = "DELETE FROM estabelecimento_favorito WHERE " + campo + " = ?";
            //Inserindo os parametros
            pstmt = conn.prepareStatement(remover);
            pstmt.setObject(1, parametro);
            return pstmt.executeUpdate();//executando o comando sql do preparedStatement
        }catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        }
        finally {
            desconectar();//fechando a conexão com o banco
        }
    }

    //método para buscar todos os dados da tabela
    public ResultSet buscar(){
        conectar();
        try{
            pstmt= conn.prepareStatement("  SELECT ef.iid, u.cnome as nomeUsuario, e.cnome, e.ccep, e.crua, e.ccidade FROM estabelecimento_favorito ef " +
                    "  JOIN estabelecimento e ON ef.iestabelecimentoid = e.iid " +
                    "  JOIN usuario u ON u.iid = ef.iestabelecimentoid");
            rs = pstmt.executeQuery();
        }catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        finally {
            desconectar();
            return rs;
        }

    }

    //método para buscar por os dados especificos da tabela
    public ResultSet buscarCampo(Object parametro, String campo){
        conectar();
        try{
            pstmt= conn.prepareStatement("  SELECT ef.iid, u.cnome as nomeUsuario, e.cnome, e.ccep, e.crua, e.ccidade FROM estabelecimento_favorito ef " +
                    "  JOIN estabelecimento e ON ef.iestabelecimentoid = e.iid " +
                    "  JOIN usuario u ON u.iid = ef.iestabelecimentoid WHERE ef." + campo + " = ? ");
            //Inserindo os parametros
            pstmt.setObject(1, parametro);
            rs = pstmt.executeQuery();
        }catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        finally {
            desconectar();
            return rs;
        }

    }



}
