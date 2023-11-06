package com.example.sevletmobisiesboco.Servlet.CRUD;//Criada em: 06/09/2023

import java.sql.*;

//Criação da classe conexão, para ligar com o banco de dados
public class Conexao {

    protected Connection conn;
    protected PreparedStatement pstmt;
    protected ResultSet rs;



    //Criação do método para conectar ao banco de dados
    public boolean conectar(){
        try {
            //Informando qual driver de conexão será utilizado pelo driveManager
            Class.forName("org.postgresql.Driver");

            //Criando a conexão
            conn = DriverManager.getConnection("jdbc:postgresql://dpg-ckc5bsciibqc739hcebg-a.oregon-postgres.render.com:5432/db_mobisi", "db_mobisi_user", "ZTthHWvhZXDHorQvJ6KnEpyPzT5pYd2B");
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            return false;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
        return true;
    }

//Criação do método para desconectar do banco
    public void desconectar(){
        try {
            if (conn != null && !conn.isClosed()) {
                //Desconectando com o banco
                conn.close();
            }
            //System.out.println("Desconectado");
        }catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

}
