package com.example.sevletmobisiesboco.Servlet.CRUD;

import com.example.sevletmobisiesboco.Servlet.Tabela.EstabelecimentoObj;
import com.example.sevletmobisiesboco.Servlet.Tabela.FormularioObj;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Formulario extends Conexao{

    //método para inserir dados da tabela
    public int inserir(FormularioObj formularioObj){
        conectar();//abrindo a conexão com o banco
        try {
            pstmt = conn.prepareStatement("INSERT INTO Formulario (iusuarioid, iestabelecimentoid, irampa, icorrimao, ibanheiro, ivagapreferencial) " +
                    "VALUES (?,?,?,?,?,?)");
            //Inserindo os parametros
            pstmt.setInt(1, formularioObj.getFk_usuario_iId());
            pstmt.setInt(2, formularioObj.getFk_Estabelecimento_iId());
            pstmt.setInt(3, formularioObj.getiRampa());
            pstmt.setInt(4, formularioObj.getiCorrimao());
            pstmt.setInt(5, formularioObj.getiBanheiro());
            pstmt.setInt(6, formularioObj.getiVagaPreferencial());
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
    public FormularioObj BuscarInformacao(int id){
        conectar();
        FormularioObj formularioObj = null;
        try{
            pstmt= conn.prepareStatement("SELECT * FROM formulario WHERE iid = ? ");
            //Inserindo os parametros
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if(rs.isBeforeFirst()){
                while(rs.next()){
                    //pegando informações do result set e add em variaveis
                    int idusuario = rs.getInt("iusuarioid");
                    int idestabelecimento = rs.getInt("iestabelecimentoid");
                    int irampa = rs.getInt("irampa");
                    int icorrimao = rs.getInt("icorrimao");
                    int ibanheiro = rs.getInt("ibanheiro");
                    int ivagapreferencial = rs.getInt("ivagapreferencial");



                    //criando objeto da tabela pra ser retorno
                    formularioObj = new FormularioObj(irampa,icorrimao,ibanheiro,ivagapreferencial,idestabelecimento,idusuario);
                    return formularioObj;
                }
            }
        }catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        finally {
            desconectar();
            return formularioObj;
        }
    }
    //método alterar, ele altera todos os campos da minha tabela a partir do id inserido
    public int alterar(FormularioObj formularioObj, int iid){
        conectar();
        try{
            pstmt = conn.prepareStatement("UPDATE Formulario SET iusuarioid = ?, iestabelecimentoid = ?, irampa = ?, icorrimao = ?, ibanheiro = ?, ivagapreferencial = ?  WHERE iId = ?");
            //Inserindo os parametros
            pstmt.setInt(1, formularioObj.getFk_usuario_iId());
            pstmt.setInt(2, formularioObj.getFk_Estabelecimento_iId());
            pstmt.setInt(3, formularioObj.getiRampa());
            pstmt.setInt(4, formularioObj.getiCorrimao());
            pstmt.setInt(5, formularioObj.getiBanheiro());
            pstmt.setInt(6, formularioObj.getiVagaPreferencial());
            pstmt.setInt(7, iid);
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
    public int remover(String campo, int parametro){
        conectar();
        try{
            String remover = "DELETE FROM Formulario WHERE " + campo + " = ?";
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
            pstmt= conn.prepareStatement("SELECT * FROM Formulario");
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
            pstmt= conn.prepareStatement("SELECT * FROM Formulario WHERE " + campo + " = ? ");
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
