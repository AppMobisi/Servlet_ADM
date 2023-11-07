package com.example.sevletmobisiesboco.Servlet.CRUD;

import com.example.sevletmobisiesboco.Servlet.Tabela.EstabelecimentoObj;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnaliseDeDados extends Conexao{
    //Método que mostra estabelecimento com avaliações acima de um número de estrelas
    public ResultSet estabelecimentoPorAvaliacao(Object parametro){
        conectar();
        try{
            pstmt= conn.prepareStatement("SELECT * FROM estabelecimento WHERE nnota > ?");
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
    //Método que encontra a deficiencia mais comum entre os usuários
    public ResultSet encontrarDeficienciaMaisComum(){
        conectar();
        try{
            pstmt= conn.prepareStatement("SELECT * FROM tp_deficiencia WHERE iid IN (" +
                    "SELECT td.iid FROM usuario u JOIN " +
                    "tp_deficiencia td ON td.iid = u.itipodeficienciaid GROUP BY 1 ORDER " +
                    "BY COUNT(u.itipodeficienciaid) DESC LIMIT 1 ) ");
            rs = pstmt.executeQuery();
        }catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        finally {
            desconectar();
            return rs;
        }
    }
    //Método que mostra os estabelecimentos com maiores avaliações
    public ResultSet estabelecimentosMaiorNota(){
        conectar();
        try{
            pstmt= conn.prepareStatement("SELECT * FROM estabelecimento WHERE nnota > 4 ORDER BY nnota ");
            //Inserindo os parametros
            rs = pstmt.executeQuery();
        }catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        finally {
            desconectar();
            return rs;
        }
    }
    //Método que mostra estabelecimento por deficiencia que mais favorita
    public ResultSet deficienciaFVEstabelecimento(int id){
        conectar();
        try{
            pstmt= conn.prepareStatement("SELECT td.cnome, e.cnome FROM tp_deficiencia td" +
                    "  JOIN usuario u ON u.itipodeficienciaid = td.iid" +
                    "  JOIN estabelecimento_favorito ef ON ef.iusuarioid = u.iid" +
                    "  JOIN estabelecimento e ON e.iid = ef.iestabelecimentoid" +
                    "   WHERE td.iid IN " +
                    "(SELECT u.itipodeficienciaid FROM usuario u WHERE u.iid IN " +
                    "(SELECT ef.iusuarioid FROM estabelecimento_favorito ef WHERE" +
                    "  ef.iestabelecimentoid = ? GROUP BY" +
                    "  1 ORDER BY COUNT(ef.iusuarioid) DESC LIMIT 1))");
            //Inserindo os parametros
            pstmt.setInt(1, id );
            rs = pstmt.executeQuery();
        }catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        finally {
            desconectar();
            return rs;
        }
    }
    //Método que mostra o estabelecimento favorito do usuário
    public ResultSet estabelecimentoFVusuario(int id){
        conectar();
        try{
            pstmt= conn.prepareStatement("SELECT * FROM estabelecimento e JOIN estabelecimento_favorito ef ON ef.iestabelecimentoid = e.iid JOIN" +
                    " usuario u ON u.iid = ef.iestabelecimentoid WHERE u.iid = ?");
            //Inserindo os parametros
            pstmt.setInt(1, id);
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
