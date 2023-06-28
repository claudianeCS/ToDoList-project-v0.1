
<%@ page import="todolist_project.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="https://fonts.googleapis.com/css2?family=Fira+Sans:ital,wght@0,400;0,700;0,900;1,400&family=Montserrat:ital,wght@0,400;0,700;0,900;1,400&display=swap" rel="stylesheet">
		<asset:stylesheet src="index.css"/>
		<title>To do List - Project</title>
	</head>
	<body>
	<main>
		<div class="title-content">
			<h1>To Do List</h1>
			<p>Escreva suas anotações e não esqueça.</p>
		</div>
		<div class="name-user">
			<g:form controller="user" action="save">
				<label for="nome">Digite seu nome:</label>
				<g:textField name="nome" value="${userIntance?.nome}"/>
				
				<g:submitButton name="entrar" value="${message(code: 'default.enviar.button', default: 'Entrar')}"/>
			</g:form>
		</div>
	</main>
	<footer>
		<p>Todos os direitos reservados, criado por CSclaudiane&copy;2023.</p>
	</footer>

	</body>
</html>
