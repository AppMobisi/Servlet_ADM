
<%@ page import="com.example.sevletmobisiesboco.Servlet.CRUD.Estabelecimento" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.example.sevletmobisiesboco.Servlet.CRUD.TpDeficiencia" %>
<%--
  Created by IntelliJ IDEA.
  User: geovannadiniz-ieg
  Date: 20/10/2023
  Time: 09:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Buscar</title>
  <link rel="stylesheet" href="../style.css">
</head>
<body>

<img src="../assets/3rings.png" alt="Style Ring" class="ThreeRings">
<header>
  <a href="https://mobisi.onrender.com/"><img class="logo" src="../assets/logoComTexto.png" alt="Logo Mobisi"></a>
  <nav class="headerNav">
    <a href="../../adm.html"><button>Tabela</button></a>
    <a href="crudTpDef.html"><button>CRUD</button></a>
  </nav>
</header>
<main>
  <section class="section1">
    <h1>Buscar </h1>
    <h2>Tabela Tipo Deficiência</h2>
    <table class="tabela" border="2px" width="90%">
      <tr>
        <th>Id</th>
        <th>Nome</th>
      </tr>
        <%
          TpDeficiencia tpDeficiencia = new TpDeficiencia();
          ResultSet rs = tpDeficiencia.buscar();
          try {
            if (rs.isBeforeFirst()) {
              while (rs.next()){
        %>
      <tr>
        <td><%= rs.getInt("iId")%></td>
        <td><%= rs.getString("cNome")%></td>
      </tr>
      <%
              }
            }
          }catch (SQLException erro){
            erro.printStackTrace();
          }
      %>
    </table>
  </section>
</main>
</body>
</html>