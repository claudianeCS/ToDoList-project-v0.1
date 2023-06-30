<%--
  Created by IntelliJ IDEA.
  User: Cldianedev
  Date: 24/06/2023
  Time: 16:10
--%>

<%@ page import="todolist_project.User" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Fira+Sans:ital,wght@0,400;0,700;0,900;1,400&family=Montserrat:ital,wght@0,400;0,700;0,900;1,400&display=swap" rel="stylesheet">
    <asset:stylesheet src="main.css"/>
    <title>To do List - Project</title>
</head>
<body>
<main class="app">
    <section class="greeting">
        <h2 class="title">
            Olá como vai,<p>${User.findById(session['userId']).nome}</p>.
        </h2>
        <button class="exit">Sair</button>
    </section>
    <section class="create-todo">
        <h3>CREATE A TODOLIST</h3>
        <g:form controller="task" action="save">
            <g:render template="/task/create" model="[taskInstanceCreated : taskInstanceCreated]"/>
            <g:submitButton name="adicionar" value="Adicionar"/>
        </g:form>
    </section>
    <section class="todo-list">
        <h3>ToDo List</h3>
        <div class="list" id="todo-list">
            <g:each in="${taskInstanceList}" var="tasks">
                <div class="todo-item">
                    <g:if test="${tasks?.categoria == "negocio"}">
                        <label>
                            <g:checkBox name="categoria" value="negocio" id="business" checked="" />
                        </label>
                    </g:if>
                    <g:else>
                        <label>
                            <g:checkBox name="categoria" value="negocio" id="personal" checked="" />
                        </label>
                    </g:else>
                        <div class="todo-content">
                            <g:textField name="tarefa" value="${tasks?.tarefa}" disabled="disabled"/>
                        </div>

                        <div class="actions">
                            <button class="edit">Editar</button>
                            <button class="delete">Deletar</button>
                        </div>
                </div>
            </g:each>

        </div>
    </section>
</main>
<footer>
    <p>Todos os direitos reservados, criado por CSclaudiane&copy;2023.</p>
</footer>

</body>
</html>