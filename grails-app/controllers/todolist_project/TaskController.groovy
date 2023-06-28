package todolist_project

import grails.transaction.Transactional

@Transactional(readOnly = true)
class TaskController {

    def index() {


        def taskList = Task.list(params)
        def task = new Task()
        [taskInstanceCreated: task, taskInstanceList: taskList]
    }


    @Transactional
    def save(Task taskInstance){
        if (taskInstance == null){
            notFound()
            return
        }

        def user = User.get(session.usuario)
        println(user)
        taskInstance.usuario = user

        if (taskInstance.hasErrors()) {
            render "Error ao salvar a tarefa", status: 500
            return
        }

        taskInstance.save flush:true

    }


    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'teste.label', default: 'Teste'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }


}
