package com.example.sevletmobisiesboco.Servlet.CRUD;

import com.example.sevletmobisiesboco.Servlet.Tabela.EstabelecimentoObj;

import java.sql.ResultSet;
import java.sql.SQLException;

//Criada em: 22/09/2023
//Classe Endereco Estabelecimento, métodos CRUD da tabela endereço estabelecimento
public class Estabelecimento extends Conexao{


    //método para inserir dados da tabela
    public int inserir(EstabelecimentoObj estabelecimentoObj){
        conectar();//abrindo a conexão com o banco
        try {
            pstmt = conn.prepareStatement("INSERT INTO Estabelecimento ( cNome, nNota, iCep, cRua, cCidade, cEstado, cFoto  itpestabelecimento) " +
                    "VALUES (?,?,?,?,?,?,?)");
            //Inserindo os parametros
            pstmt.setString(1, estabelecimentoObj.getNome());
            pstmt.setDouble(2, estabelecimentoObj.getNota());
            pstmt.setInt(3, estabelecimentoObj.getCep());
            pstmt.setString(4, estabelecimentoObj.getRua());
            pstmt.setString(5, estabelecimentoObj.getCidade());
            pstmt.setString(6, estabelecimentoObj.getEstado());
            pstmt.setString(7, estabelecimentoObj.getFoto());
            pstmt.setInt(8, estabelecimentoObj.getFkTpEstabelecimento());
            return pstmt.executeUpdate();//executando o comando sql do preparedStatement
        }catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        }
        finally {
            desconectar();//fechando a conexão com o banco
        }


    }
    //método buscar informação pelo id, e retornar um objeto da classe
    public EstabelecimentoObj BuscarInformacao(int id){
        conectar();
        EstabelecimentoObj estabelecimentoObj = null;
        try{
            pstmt= conn.prepareStatement("SELECT * FROM Estabelecimento WHERE iid = ? ");
            //Inserindo os parametros
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if(rs.isBeforeFirst()){
                while(rs.next()){
                    //pegando informações do result set e add em variaveis
                    String nome = rs.getString("cnome");
                    double nota = rs.getDouble("nnota");
                    int cep = rs.getInt("icep");
                    String rua = rs.getString("crua");
                    String cidade = rs.getString("ccidade");
                    String estado = rs.getString("cestado");
                    int idTpEst = rs.getInt("iTpEstabelecimento");
                    String foto = rs.getString("cfoto");
                    //criando objeto da tabela pra ser retorno
                    estabelecimentoObj = new EstabelecimentoObj(nome, nota, cep, rua, cidade, estado, foto, idTpEst);
                    return estabelecimentoObj;
                }
            }
        }catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        finally {
            desconectar();
            return estabelecimentoObj;
        }
    }
    //método alterar, ele altera todos os campos da minha tabela a partir do id inserido
    public int alterar(EstabelecimentoObj estabelecimentoObj, int iid){
        conectar();
        try{
            pstmt = conn.prepareStatement("UPDATE Estabelecimento SET cnome = ?, nnota = ?, icep = ?, crua = ?, ccidade = ?, cestado = ?, cfoto = ?, itpestabelecimento = ?  WHERE iid = ?");
            //Inserindo os parametros
            pstmt.setString(1, estabelecimentoObj.getNome());
            pstmt.setDouble(2, estabelecimentoObj.getNota());
            pstmt.setInt(3, estabelecimentoObj.getCep());
            pstmt.setString(4, estabelecimentoObj.getRua());
            pstmt.setString(5, estabelecimentoObj.getCidade());
            pstmt.setString(6, estabelecimentoObj.getEstado());
            pstmt.setString(7, estabelecimentoObj.getFoto());
            pstmt.setInt(8, estabelecimentoObj.getFkTpEstabelecimento());
            pstmt.setInt(9, iid);
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
            String remover = "DELETE FROM Estabelecimento WHERE " + campo + " = ?";
            //Inserindo os parâmetros
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
            pstmt= conn.prepareStatement("SELECT * FROM Estabelecimento");
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
            pstmt= conn.prepareStatement("SELECT * FROM Estabelecimento WHERE " + campo + " = ? ");
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

