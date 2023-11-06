package com.example.sevletmobisiesboco.Servlet.CRUD;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnaliseDeDados extends Conexao{
    //Método que mostra estabelecimento com avaliações acima de um número de estrelas
    public ResultSet estabelecimentoPorAvaliacao(Object parametro, String campo){
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
    public ResultSet encontrarDeficiencia(Object parametro, String campo){
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
