<%--
  Created by IntelliJ IDEA.
  User: geovannadiniz-ieg
  Date: 02/11/2023
  Time: 18:45
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
    <a href="crudForm.html"><button>CRUD</button></a>
  </nav>
</header>
<main>
  <section class="section1">
    <h1>Alterar </h1>
    <h2>Tabela Formulário</h2>

    <form action="alterarForm" method="post">
      <label for="id" >Id: </label>
      <input type="text" name="id" id="id" value="<%=request.getAttribute("id")%>" >
      <br>
      <label for="usuario">Insira o id do usuário: </label>
      <input type="text" name="usuario" id="usuario" value="<%=request.getAttribute("usuario")%>">
      <br>
      <label for="idest">Insira o id do estabelecimento: </label>
      <input type="text" name="idest" id="idest" value="<%=request.getAttribute("idest")%>">
      <br>
      <p>Insira 1 para sim e 0 para não <br>Verifique se esse estabelecimento tem: </p>
      <label for="rampa">Rampa: </label>
      <input type="text" name="rampa" id="rampa" value="<%=request.getAttribute("rampa")%>">
      <br>
      <label for="corrimao">Corrimão: </label>
      <input type="text" name="corrimao" id="corrimao" value="<%=request.getAttribute("corrimao")%>">
      <br>
      <label for="banheiro">Banheiro para PCD: </label>
      <input type="text" name="banheiro" id="banheiro" value="<%=request.getAttribute("banheiro")%>">
      <br>
      <label for="vaga">Vaga preferencial: </label>
      <input type="text" name="vaga" id="vaga" value="<%=request.getAttribute("vaga")%>">
      <br>
      <input type="submit" value="Enviar" id ="enviar">
    </form>

  </section>
</main>
</body>
</html>
