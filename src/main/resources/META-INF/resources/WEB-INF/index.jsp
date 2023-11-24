<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@page import="br.catolica.dominio.Aluno" %>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<title>Cadastro de Alunos</title>
</head>
<body>

<!-- ------------------------------------ -->
<!-- Formulario para cadastro de um aluno -->
<!-- ------------------------------------ -->
<h2>Cadastrar Novo Aluno:</h2>
<form action="/cadastrarAluno" method="get">

    <!-- ----------------------------------- -->
	<!-- Campo para informar o nome do aluno -->
	<!-- ----------------------------------- -->
	<label for="nome">Nome:</label>
	<input type="text" name="nome">
	<br><br>
	
	<!-- ----------------------------------- -->
	<!-- Campo para informar o sexo do aluno -->
	<!-- ----------------------------------- -->
	Sexo:
	<input type="radio" name="sexo" value="Masculino" class="form-label">
	<label for="sexo">Masculino</label>
	<input type="radio" name="sexo" value="Feminino">
	<label for="sexo">Feminino</label>
	<br><br>
	
	<!-- ------------------------------------------------ -->
	<!-- Campo para informar o semestre que está cursando -->
	<!-- ------------------------------------------------ -->
	<label for="semestre">Semestre</label>
	<select name="semestre">
		<option value="Primeiro">Primeiro</option>
		<option value="Segundo">Segundo</option>
		<option value="Terceiro">Terceiro</option>
		<option value="Quarto">Quarto</option>
		<option value="Quinto">Quinto</option>
		<option value="Sexto">Sexto</option>
		<option value="Sétimo">Sétimo</option>
		<option value="Oitavo">Oitavo</option>
	</select>
	<br><br>
	
	<!-- ----------------------------------------------------- -->
	<!-- Botão que submete os dados do aluno, para cadastrá-lo -->
	<!-- ----------------------------------------------------- -->
	<input type="submit" value="Confirmar Cadastro">
	<br><br>
</form>


<!--  Se a lista esta vazia, mostra mensagem de alunos nao cadastrados -->
<c:if test="${empty sessionScope.listaAlunos}">			

   <h2>Ainda não há alunos cadastrados.</h2>
</c:if>

<!-- Caso contrario, mostra tabela com os alunos cadastrados -->   	
<c:if test="${not empty sessionScope.listaAlunos}">

	<c:if test="${not empty requestScope.alunoCadastrado}">
		<h2>Aluno cadastrado:</h2>
		Id: ${requestScope.alunoCadastrado.id}
		Nome: ${requestScope.alunoCadastrado.nome}
		Sexo: ${requestScope.alunoCadastrado.sexo}
		Semestre: ${requestScope.alunoCadastrado.semestre}
	</c:if>

	<!-- --------------------------------------- -->
	<!-- Tabela que mostra os alunos cadastrados -->
	<!-- --------------------------------------- -->
	<h2>Alunos Cadastrados:</h2>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Sexo</th>
			<th>Semestre</th>
			<th>Excluir</th>
		</tr>	
		
		<c:forEach var="aluno" items="${sessionScope.listaAlunos}">
		
		<tr>
			<td> ${aluno.id} </td>
			<td> ${aluno.nome} </td>
			<td> ${aluno.sexo} </td>
			<td> ${aluno.semestre} </td>
			<td> <a href="/excluirAluno?id=${aluno.id}">Excluir</a> </td>
		</tr>		
		
		</c:forEach>
				
	</table>

</c:if>

</body>
</html>