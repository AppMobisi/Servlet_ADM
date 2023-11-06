
<%@ page import="java.sql.*" %>
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
  <link rel="stylesheet" href="../../Entrada/style.css">
  <style>
    .section1{
      height: 50vh;
    }
    html{
      block-size: 100%;
    }

  </style>
</head>
<body>

<img src="../../Entrada/assets/3rings.png" alt="Style Ring" class="ThreeRings">
<header>
  <a href="https://mobisi.onrender.com/"><img class="logo" src="../../Entrada/assets/logoComTexto.png" alt="Logo Mobisi"></a>
  <nav class="headerNav">
    <a href="../../adm.html"><button>Tabela</button></a>
    <a href="crudEst.html"><button>CRUD</button></a>
  </nav>
</header>
<main>
  <section class="section1">
    <h1>Buscar </h1>
    <h2>Tabela Estabelecimento Favorito</h2>
    <table class="tabela" border=2 width="90%">
      <tr>
        <th>Id</th>
        <th>Id usuario</th>
        <th>Estabelecimento Id</th>
      </tr>
      <%
        ResultSet rs = (ResultSet) request.getAttribute("resultado");
        try {
          while (rs.next()){
      %>
      <tr>
        <td><%= rs.getString("iId")%></td>
        <td><%= rs.getInt("iUsuarioId")%></td>
        <td><%= rs.getInt("iEstabelecimentoId")%></td>
      </tr>
      <% }
      }catch (SQLException erro){
        erro.printStackTrace();
      } %>
    </table>
  </section>
</main>
</body>
</html>
