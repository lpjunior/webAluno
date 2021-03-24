<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="pt-br">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
	crossorigin="anonymous" />
<title>Controle de Alunos</title>
</head>
<body>
	<div class="container">
		<div class="text-center">
			<h1>Controle de Alunos</h1>
		</div>

		<form class="form" action="addaluno" method="post">
			<h3 class="mb-2">Dados básicos</h3>
			<input type="hidden" id="_id" name="inputid" class="form-control" value="${aluno.id}">
			<div class="form-group">
				<label for="nomeid">Nome</label> 
				<input type="text" id="nomeid"
					name="inputnome" class="form-control" value="${aluno.nome}"
					placeholder="Informe o nome do aluno" autofocus required>
			</div>
			<div class="form-group">
				<label for="matriculaid">Matricula</label> 
				<input type="number" id="matriculaid" 
					name="inputmatricula" class="form-control" value="${aluno.matricula}"
					placeholder="Informe a matricula do aluno" required>
			</div>
			<div class="form-group">
				<label for="emailid">E-mail</label> 
				<input type="text" id="emailid"
					name="inputemail" class="form-control" value="${aluno.email}"
					placeholder="Informe o e-mail do aluno" required>
			</div>
			<div class="form-group">
				<label for="telefoneid">Telefone</label> 
				<input type="text" id="telefoneid" 
				name="inputtelefone" class="form-control" value="${aluno.telefone}"
					placeholder="Informe o telefone do aluno" required>
			</div>
			<h3 class="my-2">Dados endereço</h3>
			<div class="form-group">
				<label for="logradouroid">Logradouro</label> 
				<input type="text" id="logradouroid" 
				name="inputlogradouro" class="form-control" value="${aluno.endereco.logradouro}"
					placeholder="Informe o logradouro do endereço" required>
			</div>
			<div class="form-group">
				<label for="bairroid">Bairro</label> 
				<input type="text"
					id="bairroid" name="inputbairro" class="form-control" value="${aluno.endereco.bairro}"
					placeholder="Informe o bairro do endereço" required>
			</div>
			<div class="form-group">
				<label for="cidadeid">Cidade</label> 
				<input type="text"
					id="cidadeid" name="inputcidade" class="form-control" value="${aluno.endereco.cidade}"
					placeholder="Informe o cidade do endereço" required>
			</div>
			<div class="form-group">
				<label for="estadoid">Estado</label> 
				<input type="text"
					id="estadoid" name="inputestado" class="form-control" value="${aluno.endereco.estado}"
					placeholder="Informe o estado do endereço" required>
			</div>
			<button type="submit" class="btn btn-dark btn-lg my-2">Incluir</button>
		</form>
		<br>
		<hr>
		<br>
		<table class="table table-hover table-bordered table-responsive">
			<thead>
				<tr class="text-center">
					<th>Nome</th>
					<th>Matricula</th>
					<th>E-mail</th>
					<th>Telefone</th>
					<th>Logradouro</th>
					<th>Bairro</th>
					<th>Cidade</th>
					<th>Estado</th>
					<th colspan="2">Gerenciar</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="aluno" items="${requestScope.lista}">
					<tr class="text-center">
						<td>${aluno.nome}</td>
						<td>${aluno.matricula}</td>
						<td>${aluno.email}</td>
						<td>${aluno.telefone}</td>
						<td>${aluno.endereco.logradouro}</td>
						<td>${aluno.endereco.bairro}</td>
						<td>${aluno.endereco.cidade}</td>
						<td>${aluno.endereco.estado}</td>
						<td><a href="findaluno?id=${aluno.id}"><i class="fas fa-pencil-alt"></i></a></td>
						<td><a href="delaluno?id=${aluno.id}" onclick="return confirm('Confirma a exclusão do aluno ${aluno.nome}?') "><i class="fas fa-trash-alt text-danger"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
		crossorigin="anonymous"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
    -->
</body>
</html>