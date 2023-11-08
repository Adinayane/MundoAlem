<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cadastre-se - Mundo Alem</title>
    <link rel="stylesheet" type="text/css" href="../css/estilo.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<body>
<div class="bg-primary bg-gradient">
    
      <!--Conteúdo-->
      <div class="text-nav titulo">
        <h2>Cadastre-se e viaje Mundo Além!</h2>
      </div>
      <div class="row p-3">
        <div class="form-container">
          <form action="/MundoAlem/inserirUsuario" method="post">
          	<div class="form-group">
              <label for="name">Nome:</label>
              <input type="text" id="name" name="name" required>
            </div>
            <div class="form-group">
              <label for="cpf">CPF:</label>
              <input type="text" id="cpf" name="cpf" required>
            </div>
            <div class="form-group">
              <label for="date">Data de Nascimento (insira no formato dd-mm-yyyy):</label>
              <input type="text" id="date" name="datanasc" required>
            </div>
            <div class="form-group">
              <label for="email">Email:</label>
              <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
              <label for="password">Senha:</label>
              <input type="password" id="password" name="password" required>
            </div>
            <button type="submit" id="cadastrarCliente" name="cadastrarCliente" >Cadastrar</button>
          </form>
        </div>
      </div>
      <!--Rodapé-->
      <div class="estilo-rodape text-nav">
       <footer>
          MundoAlém
          <div class="d-flex justify-content-center">
            <div class="col-md-1">
              <img src="../midia/facebook.jpg" width="30px" height="30px" title="logo do facebook">
            </div>
            <div class="col-md-1">
              <img src="../midia/linkedin.png" width="30px" height="30px" title="logo do LinkedIn">
            </div>
            <div class="col-md-1">
              <img src="../midia/instagram.jpg" width="30px" height="30px" title="logo do Instagram">
            </div>
          </div>
        </footer>

      </div>
    </div>
    <!--fim do rodapé-->
    </div>

</body>
</html>