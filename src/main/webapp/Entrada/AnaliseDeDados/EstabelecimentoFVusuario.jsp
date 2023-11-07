<%@ page import="java.sql.*" %>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Estabelecimento favorito do usuário</title>
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
    <a href="../../adm.html"><button>Acesso do ADM</button></a>
    <a href="crudEst.html"><button>CRUD</button></a>
  </nav>
</header>
<main>
  <section class="section1">
    <h1>Estabelecimento favorito do usuário</h1>
    <h2>Tabela Estabelecimento e EstabelecimentoFavorito</h2>
    <table class="tabela" border=2 width="90%">
      <tr>
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
        ResultSet rs = (ResultSet) request.getAttribute("resultado");
        try {
          while (rs.next()){
      %>
      <tr>
        <td style="text-align: center"><%= rs.getString("cNome")%></td>
        <td><%= rs.getDouble("nNota")%></td>
        <td><%= rs.getInt("iCep")%></td>
        <td><%= rs.getString("cRua")%></td>
        <td><%= rs.getString("cCidade")%></td>
        <td><%= rs.getString("cEstado")%></td>
        <td><%= rs.getString("cFoto")%></td>
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


</body>
</html>
