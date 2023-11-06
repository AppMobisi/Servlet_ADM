package CRUD;

import com.example.sevletmobisiesboco.Servlet.CRUD.Estabelecimento;
import com.example.sevletmobisiesboco.Servlet.Tabela.EstabelecimentoObj;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
//Criando os objetos
//        TpDeficiencia tpDeficiencia = new TpDeficiencia();
//        TpEstabelecimento tpEstabelecimento = new TpEstabelecimento();
//        EstabelecimentoFv estabelecimentoFv = new EstabelecimentoFv();
//        Formulario formulario = new Formulario();
//
////INSERINDO
//        System.out.println(tpDeficiencia.inserir("cego"));
//        System.out.println(tpEstabelecimento.inserir("mamao"));
//        System.out.println(estabelecimento.inserir("ge", 4.5, 1234789, "aaaaa", "bbbbb", "cccccc", "hsdkj", 2));
//        System.out.println(estabelecimentoFv.inserir(2,2));
//        System.out.println(formulario.inserir(1,2,3,4));
//
////BUSCANDO
//        try {
//            System.out.println("Mostrando os valores da tabela estabelecimento");
//            ResultSet rs = estabelecimento.buscar();
//            while (rs.next()) {
//                String lista = ("Codigo Estabelecimento: " + rs.getInt("iId") + " - Nota: " + rs.getDouble("nNota") + " - CEP: " + rs.getInt("iCep"));
//                System.out.println(lista);
//            }
//        } catch (SQLException sqle) {
//            sqle.printStackTrace();
//        }
//        try {
//            System.out.println("Mostrando os valores da tabela tpDeficiencia");
//            ResultSet rs = tpDeficiencia.buscar();
//            while (rs.next()) {
//                String lista = ("Id: " + rs.getInt("iId") + " - Nome: " + rs.getString("cNome"));
//                System.out.println(lista);
//            }
//        } catch (SQLException sqle) {
//            sqle.printStackTrace();
//        }
//        try {
//            System.out.println("Mostrando os valores da tabela tpEstabelecimento");
//            ResultSet rs = tpEstabelecimento.buscar();
//            while (rs.next()) {
//                String lista = ("Id: " + rs.getInt("iId") + " - Nome: " + rs.getString("cNome"));
//                System.out.println(lista);
//            }
//        } catch (SQLException sqle) {
//            sqle.printStackTrace();
//        }
//        try {
//            System.out.println("Mostrando os valores da tabela estabelecimentoFv");
//            ResultSet rs = estabelecimentoFv.buscar();
//            while (rs.next()) {
//                String lista = ("Id Usuario: " + rs.getInt("iUsuarioId") + " - id Estabelecimento: " + rs.getString("iEstabelecimentoId"));
//                System.out.println(lista);
//            }
//        } catch (SQLException sqle) {
//            sqle.printStackTrace();
//        }
//        try {
//            System.out.println("Mostrando os valores da tabela formulario");
//            ResultSet rs = formulario.buscar();
//            while (rs.next()) {
//                String lista = ("Id: " + rs.getInt("iId") + " - Rampa: " + rs.getInt("iRampa") + " - Corrimao: " + rs.getInt("iCorrimao") + " - Banheiro: " + rs.getInt("iBanheiro") + " - iVagaPreferencial: " + rs.getInt("iVagaPreferencial"));
//                System.out.println(lista);
//            }
//        } catch (SQLException sqle) {
//            sqle.printStackTrace();
//        }
//
//
//
////ALTERANDO
//
//        System.out.println(tpDeficiencia.alterar(2,"mudo"));
//        System.out.println(tpEstabelecimento.alterar(2, "restaurante"));
//        System.out.println(estabelecimento.alterar("cNome", 2, "hoje"));
//        System.out.println(formulario.alterar("iRampa", 2, 4));
//
//
//
//
////REMOVENDO
//
//        //System.out.println(estabelecimentoFv.remover("iId", 2));
//        //System.out.println(estabelecimento.remover("iId", 1));
//        //System.out.println(tpEstabelecimento.remover("iId", 1));
//        //System.out.println(tpDeficiencia.remover("iId", 1));
//        //System.out.println(formulario.remover("iId", 1));
//
////BUSCANDO POR ID
//
//        try {
//            System.out.println("Mostrando os valores da tabela estabelecimento");
//            ResultSet rs = estabelecimento.buscarEspecifico("iID", 2);
//            while (rs.next()) {
//                String lista = ("Codigo Estabelecimento: " + rs.getInt("iId") + " - Nota: " + rs.getDouble("nNota") + " - CEP: " + rs.getInt("iCep"));
//                System.out.println(lista);
//            }
//        } catch (SQLException sqle) {
//            sqle.printStackTrace();
//        }
//        try {
//            System.out.println("Mostrando os valores da tabela tpDeficiencia");
//            ResultSet rs = tpDeficiencia.buscarEspecifico("iID", 2);
//            while (rs.next()) {
//                String lista = ("Id: " + rs.getInt("iId") + " - Nome: " + rs.getString("cNome"));
//                System.out.println(lista);
//            }
//        } catch (SQLException sqle) {
//            sqle.printStackTrace();
//        }
//        try {
//            System.out.println("Mostrando os valores da tabela tpEstabelecimento");
//            ResultSet rs = tpEstabelecimento.buscarEspecifico("iID", 2);
//            while (rs.next()) {
//                String lista = ("Id: " + rs.getInt("iId") + " - Nome: " + rs.getString("cNome"));
//                System.out.println(lista);
//            }
//        } catch (SQLException sqle) {
//            sqle.printStackTrace();
//        }
//        try {
//            System.out.println("Mostrando os valores da tabela estabelecimentoFv");
//            ResultSet rs = estabelecimentoFv.buscarEspecifico("iID", 2);
//            while (rs.next()) {
//                String lista = ("Id Usuario: " + rs.getInt("iUsuarioId") + " - id Estabelecimento: " + rs.getString("iEstabelecimentoId"));
//                System.out.println(lista);
//            }
//        } catch (SQLException sqle) {
//            sqle.printStackTrace();
//        }
//        try {
//            System.out.println("Mostrando os valores da tabela formulario");
//            ResultSet rs = formulario.buscarEspecifico("iID", 2);
//            while (rs.next()) {
//                String lista = ("Id: " + rs.getInt("iId") + " - Rampa: " + rs.getInt("iRampa") + " - Corrimao: " + rs.getInt("iCorrimao") + " - Banheiro: " + rs.getInt("iBanheiro") + " - iVagaPreferencial: " + rs.getInt("iVagaPreferencial"));
//                System.out.println(lista);
//            }
//        } catch (SQLException sqle) {
//            sqle.printStackTrace();
//        }
    }
}


