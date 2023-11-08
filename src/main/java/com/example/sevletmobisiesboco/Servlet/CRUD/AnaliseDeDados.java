package com.example.sevletmobisiesboco.Servlet.CRUD;

import com.example.sevletmobisiesboco.Servlet.Tabela.EstabelecimentoObj;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnaliseDeDados extends Conexao{
    //Método que mostra estabelecimento com avaliações acima de um número de estrelas
    public ResultSet estabelecimentoPorAvaliacao(double parametro){
        conectar();
        try{
            pstmt= conn.prepareStatement("SELECT * FROM estabelecimento WHERE nnota > ?");
            //Inserindo os parametros
            pstmt.setDouble(1, parametro);
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
            pstmt= conn.prepareStatement("SELECT td.iid, td.cnome, COUNT(u.itipodeficienciaid) AS quantidade FROM usuario u JOIN" +
                    "tp_deficiencia td ON td.iid = u.itipodeficienciaid GROUP BY 1,2 ORDER " +
                    "BY 3 DESC LIMIT 1");
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
            pstmt= conn.prepareStatement("SELECT * FROM estabelecimento WHERE nnota > 4 ORDER BY nnota DESC ");
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
    //Método que mostra estabelecimento por deficiencia que é mais acessivel no local
    public ResultSet deficienciaFvEstabelecimento(int parametro){
        conectar();
        try{
            pstmt= conn.prepareStatement("select td.cnome AS cnomeDef, e.* from tp_deficiencia td" +
                    "  join usuario u on u.itipodeficienciaid = td.iid" +
                    "  join estabelecimento_favorito ef on ef.iusuarioid = u.iid" +
                    "  join estabelecimento e on e.iid = ef.iestabelecimentoid" +
                    "   where td.iid in " +
                    "(select u.itipodeficienciaid from usuario u where u.iid in  " +
                    "(select ef.iusuarioid from estabelecimento_favorito ef where" +
                    "  ef.iestabelecimentoid = ? group by" +
                    "  1 order by count(ef.iusuarioid) desc limit 1))");
            //Inserindo os parametros
            pstmt.setInt(1, parametro );
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
    public ResultSet estabelecimentoFVusuario(Object parametro, String campo){
        conectar();
        try{
            pstmt= conn.prepareStatement(" SELECT ef.iid, u.cnome as nomeUsuario, e.cnome, e.ccep, e.crua, e.ccidade FROM estabelecimento_favorito ef " +
                    "  JOIN estabelecimento e ON ef.iestabelecimentoid = e.iid " +
                    "  JOIN usuario u ON u.iid = ef.iestabelecimentoid WHERE u." + campo  + " = ?");
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
