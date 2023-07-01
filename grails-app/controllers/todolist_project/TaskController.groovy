package todolist_project

import grails.transaction.Transactional

@Transactional(readOnly = true)
class TaskController {

    static allowedMethods = [save: "POST"]

    def index() {

        def taskList = Task.list(params)
        def task = new Task()
        [taskInstanceCreated: task, taskInstanceList: taskList]
    }

    @Transactional
    def edit(Task taskInstance){
        if (taskInstance == null){
            notFound()
            return
        }

        taskInstance?.usuario = User.get(session['userId'])
        taskInstance.save flush:true

        redirect(action: 'index')
    }



    @Transactional
    def save(Task taskInstance){
        if (taskInstance == null){
            notFound()
            return
        }

        taskInstance?.usuario = User.get(session['userId'])
        taskInstance.save flush:true

        redirect(action: 'index')

    }

    def delete(Long id){
        def task = Task.get(id)
        if (task){
            task.delete(flush: true)
        }
        redirect(action: 'index')
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
