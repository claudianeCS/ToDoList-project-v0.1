<%--
  Created by IntelliJ IDEA.
  User: Cldianedev
  Date: 17/09/2023
  Time: 23:41
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Fira+Sans:ital,wght@0,400;0,700;0,900;1,400&family=Montserrat:ital,wght@0,400;0,700;0,900;1,400&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="${assetPath(src: 'lista-de-controle.png')}" type="image/x-icon">
    <asset:stylesheet src="index.css"/>
    <title>To do List - Project</title>
</head>

<body>
<main>
    <div class="title-content">
        <h1>ToDo List</h1>
        <p>Organize suas terafas..</p>
    </div>

    <form action='${request.contextPath}/j_spring_security_check' method='POST' id='frmLogar' name='frmLogar'>
        <div>
            <label>Username</label>
            <input type='text' name='j_username' id='username' />
        </div>
        <div>
            <label>Senha</label>
            <input type='password' name='j_password' id='password' />
        </div>
        <input type="submit" value="Entrar" />
    </form>
</main>
<footer>
    <p>Todos os direitos reservados, criado por CSclaudiane&copy;2023.</p>
</footer>

</body>
</html>