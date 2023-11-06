
<%@ page import="com.example.sevletmobisiesboco.Servlet.CRUD.Estabelecimento" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.example.sevletmobisiesboco.Servlet.CRUD.Formulario" %>
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
  <title>Busca</title>
  <link rel="stylesheet" href="../style.css">

</head>
<body>

<img src="../assets/3rings.png" alt="Style Ring" class="ThreeRings">
<header>
  <a href="https://mobisi.onrender.com/"><img class="logo" src="../assets/logoComTexto.png" alt="Logo Mobisi"></a>
  <nav class="headerNav">
    <a href="../../adm.html"><button>Tabela</button></a>
    <a href="crudForm.html"><button>CRUD</button></a>
  </nav>
</header>
<main>
  <section class="section1">
    <h1>Buscar </h1>
    <h2>Tabela Formulário</h2>

    <table class="tabela" border=2 width="90%">
      <tr>
        <th>Id</th>
        <th>Usuário Id</th>
        <th>Estabelecimento Id</th>
        <th>Rampa</th>
        <th>Corrimão</th>
        <th>Banheiro</th>
        <th>Vaga Preferencial</th>

      </tr>
      <%
        Formulario formulario = new Formulario();
        ResultSet rs = formulario.buscar();
        try {
          while (rs.next()){
      %>
      <tr>
        <td><%= rs.getInt("iId")%></td>
        <td><%= rs.getInt("iUsuarioId")%></td>
        <td><%= rs.getInt("iEstabelecimentoId")%></td>
        <td><%= rs.getInt("iRampa")%></td>
        <td><%= rs.getInt("iCorrimao")%></td>
        <td><%= rs.getInt("iBanheiro")%></td>
        <td><%= rs.getInt("iVagaPreferencial")%></td>

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