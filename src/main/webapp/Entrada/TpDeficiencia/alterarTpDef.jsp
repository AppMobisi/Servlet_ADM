<%--
  Created by IntelliJ IDEA.
  User: geovannadiniz-ieg
  Date: 02/11/2023
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Alterar</title>
  <link rel="stylesheet" href="../style.css">

</head>
<body>
<img src="../assets/3rings.png" alt="Style Ring" class="ThreeRings">
<header>
  <a href="https://mobisi.onrender.com/"><img class="logo" src="../assets/logoComTexto.png" alt="Logo Mobisi"></a>
  <nav class="headerNav">
    <a href="../../adm.html"><button>Acesso do ADM</button></a>
    <a href="crudTpDef.html"><button>CRUD</button></a>
  </nav>
</header>
<main>
  <section class="section1">
    <h1>Alterar </h1>
    <h2>Tabela Tipo Deficiência</h2>
    <form action="alterarTpDef" method="post">
      <label for="id" >Id</label>
      <input type="text" name="id" id="id" value="<%=request.getAttribute("id")%>" >
      <br>
      <label for="nome">Insira o nome</label>
      <input type="text" name="nome" id="nome" value="<%=request.getAttribute("nome")%>">
      <input type="submit" value="Enviar" id ="enviar">
    </form>

  </section>
</main>
</body>
</html>
