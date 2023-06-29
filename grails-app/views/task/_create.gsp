 <h4>Qual e a sua tarefa?</h4>
    <g:textField name="tarefa" id="content" placeholder="lembrar de fazer um video" value="${taskInstanceCreated?.tarefa}"/>
    <h4>Escolha uma categoria</h4>
    <div class="options">
        <label>
            <g:radio name="categoria" value="negocio" id="vanilla" checked="${taskInstanceCreated?.categoria == 'negocio'}"/>
            <div>Negocios</div>
        </label>
        <label>
            <g:radio name="categoria" value="pessoal" id="vanilla" checked="${taskInstanceCreated?.categoria == 'pessoal'}"/>
            <div>Pessoal</div>
        </label>
    </div>


