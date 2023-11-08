<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

  
<!DOCTYPE html>
<html>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Perfil - MundoAlém</title>
    <link rel="stylesheet" type="text/css" href="../css/estilo.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	<style>
		  body {
		    margin: 2px;
		    text-align: center;
		  }

	  .container {
	    display: flex;
	    flex-direction: column;
	    align-items: center;
	    
	    height: 100vh;
	  }
	  
	</style>
</head>
<body>
	<div class="container">
		<div>
			<br>
			<h3>DADOS DO USUÁRIO</h3>
			<br>
			<table style="border: 1px solid #000; border-collapse: collapse;">
				<thead>
					<tr>
						<th style="border: 1px solid #000;">CPF</th>
						<th style="border: 1px solid #000;">Nome</th>
						<th style="border: 1px solid #000;">Data de Nascimento</th>
						<th style="border: 1px solid #000;">E-mail</th>
						<th style="border: 1px solid #000;">Ações</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${perfiluser}" var="dado">
						<tr>
							<td style="border: 1px solid #000;">${dado.cpf}</td>
							<td style="border: 1px solid #000;">${dado.nome}</td>
							<td style="border: 1px solid #000;">${dado.dataNasc}</td>
							<td style="border: 1px solid #000;">${dado.email}</td>
							<td style="border: 1px solid #000;">
								<a href="editarUsuario?cpf=${dado.cpf}" class="btn btn-success">Editar</a>  
								<a href="deletarUsuario?cpf=${dado.cpf}" onclick="return confirm('Deseja Excluir ${dado.nome}?')" class="btn btn-danger">Excluir</a>
								<a href="/MundoAlem/login" class="btn btn-info">SAIR</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<br>
			<br>
			<h3>SUAS VIAGENS</h3>
			<br>
			<div>
				<table>
				<thead>
					<tr>
						<th style="border: 1px solid #000;">IdPagamento</th>
						<th style="border: 1px solid #000;">Nº Viagem</th>
						<th style="border: 1px solid #000;">Ida</th>
						<th style="border: 1px solid #000;">Volta</th>
						<th style="border: 1px solid #000;">Valor</th>
						<th style="border: 1px solid #000;">qtd. Parcelas</th>
						<th style="border: 1px solid #000;">Valor/Parcela</th>
						<th style="border: 1px solid #000;">Vencimento</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pgs}" var="pags">
						<tr>
						<td style="border: 1px solid #000;">${pags.idPag}</td>
					</c:forEach>
					<c:forEach items="${destEsc}" var="escolhido">
						
							<td style="border: 1px solid #000;">${escolhido.numViagem}</td>
							<td style="border: 1px solid #000;">${escolhido.dataIda}</td>
							<td style="border: 1px solid #000;">${escolhido.dataVolta}</td>
					</c:forEach>
					<c:forEach items="${pgs}" var="pags">
							<td style="border: 1px solid #000;">${pags.valor}</td>
							<td style="border: 1px solid #000;">${pags.parcelas}</td>
							<td style="border: 1px solid #000;">${pags.valorParcela}</td>
							<td style="border: 1px solid #000;">${pags.dataVenc}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<a href="requisitarViagem?cpf=${dado.cpf}" class="btn btn-success">Nova Viagem</a> 
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>