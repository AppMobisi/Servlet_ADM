<%@ page import="java.sql.*" %>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Estabelecimento mais acessível para uma deficiência</title>
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
    <a href="crudAnaliseDeDados.html"><button>CRUD</button></a>
  </nav>
</header>
<main>
  <section class="section1">
    <h1>Buscar o estabelecimento mais acessível para uma deficiência</h1>
    <h2>Analise de dados</h2>
    <table class="tabela" border=2 width="90%">
      <tr>
        <th>Tipo de deficiência</th>
        <th>Nome do estabelecimento</th>
        <th>CEP</th>
        <th>Rua</th>
        <th>Cidade</th>
        <th>Estado</th>
        <th>Nota</th>
      </tr>
      <%
        ResultSet rs = (ResultSet) request.getAttribute("resultado");
        try {
          while (rs.next()){
      %>
      <tr>
        <td style="text-align: center"><%= rs.getString("cnomeDef")%></td>
        <td><%= rs.getString("cnomeEst")%></td>
        <td><%= rs.getString("cCep")%></td>
        <td><%= rs.getString("cRua")%></td>
        <td><%= rs.getString("cCidade")%></td>
        <td><%= rs.getString("cEstado")%></td>
        <td><%= rs.getString("nNota")%></td>

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
