package com.example.sevletmobisiesboco.Servlet.CRUD;

import com.example.sevletmobisiesboco.Servlet.Tabela.TpDeficienciaObj;
import com.example.sevletmobisiesboco.Servlet.Tabela.TpEstabelecimentoObj;

import java.sql.ResultSet;
import java.sql.SQLException;
//Criada em 22/09/23
//Classe TpEstabelecimento, métodos CRUD da tabela tp_estabelecimento

public class TpEstabelecimento extends Conexao {

    //método para inserir dados da tabela
    public int inserir(TpEstabelecimentoObj tpEstabelecimentoObj) {
        conectar();//abrindo a conexão com o banco
        try {
            pstmt = conn.prepareStatement("INSERT INTO Tp_estabelecimento (cNome) " +
                    "VALUES(?) ");
            //Inserindo os parametros
            pstmt.setString(1, tpEstabelecimentoObj.getcNome());

            return pstmt.executeUpdate();//executando o comando sql do preparedStatement
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } finally {
            desconectar();//fechando a conexão com o banco
        }
    }

    //método buscar informação pelo id, e retornar um objeto da classe
    public TpEstabelecimentoObj BuscarInformacao(int id){
        conectar();
        TpEstabelecimentoObj tpEstabelecimentoObj = null;
        try{
            pstmt= conn.prepareStatement("SELECT * FROM tp_estabelecimento WHERE iid = ? ");
            //Inserindo os parametros
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if(rs.isBeforeFirst()){
                while(rs.next()){
                    //pegando informações do result set e add em variaveis
                    String nome = rs.getString("cnome");

                    //criando objeto da tabela pra ser retorno
                    tpEstabelecimentoObj = new TpEstabelecimentoObj(nome);
                    return tpEstabelecimentoObj;
                }
            }
        }catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        finally {
            desconectar();
            return tpEstabelecimentoObj;
        }
    }
    //método alterar, ele altera todos os campos da minha tabela a partir do id inserido
    public int alterar(TpEstabelecimentoObj tpEstabelecimentoObj, int iid){
        conectar();
        try{
            pstmt = conn.prepareStatement("UPDATE tp_estabelecimento SET cnome = ? WHERE iId = ?");
            //Inserindo os parametros
            pstmt.setString(1, tpEstabelecimentoObj.getcNome());
            pstmt.setInt(2, iid);
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
    public int remover(String campo, Object parametro) {
        conectar();
        try {
            String remover = "DELETE FROM Tp_estabelecimento WHERE " + campo + " = ?";
            //Inserindo os parametros
            pstmt = conn.prepareStatement(remover);
            pstmt.setObject(1, parametro);
            return pstmt.executeUpdate();//executando o comando sql do preparedStatement
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } finally {
            desconectar();//fechando a conexão com o banco
        }
    }

    //método para buscar todos os dados da tabela
    public ResultSet buscar() {
        conectar();
        try {
            pstmt = conn.prepareStatement("SELECT * FROM Tp_estabelecimento");
            rs = pstmt.executeQuery();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            desconectar();
            return rs;
        }

    }

    //método para buscar por os dados especificos da tabela
    public ResultSet buscarCampo(Object parametro, String campo) {
        conectar();
        try {
            pstmt = conn.prepareStatement("SELECT * FROM Tp_estabelecimento WHERE " + campo + " = ? ");
            //Inserindo os parametros
            pstmt.setObject(1, parametro);
            rs = pstmt.executeQuery();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            desconectar();
            return rs;
        }

    }
}
