<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

  
<!DOCTYPE html>
<html>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Perfil</title>
    <link rel="stylesheet" type="text/css" href="../css/estilo.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<br>
		<h4>Editar informações de ${usuario.nome}</h4>
		<form action="/MundoAlem/editarUsuario" method="post" class="form-control">
			<p>CPF:
				<input type="text" name="cpf" value="${usuario.cpf}" readonly>
			</p>
			<p>Nome:
				<input type="text" name="nome" value="${usuario.nome}">
			</p>
			<p>Data de Nascimento (formato: dd-mm-yyyy):
				<input type="text" name="datanasc" value="${usuario.dataNasc}">
			</p>
			<p>email:
				<input type="text" name="email" value="${usuario.email}">
			</p>
			<button type="submit" class="btn btn-success">Atualizar</button>
			<a href="/MundoAlem/perfil?email=${usuario.email}&password=${usuario.senha}" class="btn btn-danger">Cancelar</a>
		</form>
	</div>
</body>
</html>