
<%@ page import="com.example.sevletmobisiesboco.Servlet.CRUD.Estabelecimento" %>
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
    <a href="crudEst.html"><button>CRUD</button></a>
  </nav>
</header>
<main>
  <section class="section1">
    <h1>Mostrar tudo</h1>
    <h2>Tabela Estabelecimento</h2>
    <table class="tabela" border=2 width="90%">
      <tr>
        <th>Id</th>
        <th>Nome</th>
        <th>Nota</th>
        <th>CEP</th>
        <th>Rua</th>
        <th>Cidade</th>
        <th>Estado</th>
        <th>Foto</th>
        <th>Tp Estabelecimento</th>
      </tr>
      <%
        Estabelecimento estabelecimento = new Estabelecimento();
        ResultSet rs = estabelecimento.buscar();
        try {
          while (rs.next()){
      %>
      <tr>
        <td><%= rs.getString("iId")%></td>
        <td><%= rs.getString("cNome")%></td>
        <td><%= rs.getDouble("nNota")%></td>
        <td><%= rs.getInt("iCep")%></td>
        <td><%= rs.getString("cRua")%></td>
        <td><%= rs.getString("cCidade")%></td>
        <td><%= rs.getString("cEstado")%></td>
        <td><%= rs.getInt("cFoto")%></td>
        <td><%= rs.getInt("itpestabelecimento")%></td>
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