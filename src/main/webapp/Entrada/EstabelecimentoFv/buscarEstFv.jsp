
<%@ page import="com.example.sevletmobisiesboco.Servlet.CRUD.EstabelecimentoFv" %>
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
  <link rel="stylesheet" href="../style.css">

</head>
<body>

<img src="../assets/3rings.png" alt="Style Ring" class="ThreeRings">
<header>
  <a href="https://mobisi.onrender.com/"><img class="logo" src="../assets/logoComTexto.png" alt="Logo Mobisi"></a>
  <nav class="headerNav">
    <a href="../../adm.html"><button>Acesso do ADM</button></a>
    <a href="crudEstFv.html"><button>CRUD</button></a>
  </nav>
</header>
<main>
  <section class="section1">
    <h1>Mostrar tudo</h1>
    <h2>Tabela Estabelecimento Favorito</h2>

    <table class="tabela" border=2 width="90%">
      <tr>
        <th>Id</th>
        <th>Nome do usuário</th>
        <th>Nome do estabelecimento</th>
        <th>CEP</th>
        <th>Cidade</th>
        <th>Rua</th>
      </tr>
      <%
        EstabelecimentoFv estabelecimentoFv = new EstabelecimentoFv();
        ResultSet rs = estabelecimentoFv.buscar();
        try {
          while (rs.next()){
      %>
      <tr>
        <td><%= rs.getInt("iid")%></td>
        <td><%= rs.getString("nomeUsuario")%></td>
        <td><%= rs.getString("cnome")%></td>
        <td><%= rs.getString("ccep")%></td>
        <td><%= rs.getString("ccidade")%></td>
        <td><%= rs.getString("crua")%></td>
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