package todolist_project

import javax.servlet.http.HttpSession

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UserController {

    static allowedMethods = [save: "POST"]

    def index() {
        def user = new User()
        [userIntance: user]
    }


    @Transactional
    def save(User userInstance) {
        if (userInstance == null) {
            notFound()
            return
        }


   /*     def users = User.porNome(userInstance?.nome).list()
        if (users){
            users.each {user ->
                user.delete(flush: true)
            }
        }*/

        if (userInstance.hasErrors()) {
            render "Error no nome de usuario", status: 500
            return
        }

        userInstance.save flush:true
        usuarioSessao(userInstance?.id)

        if (userInstance){
            session.setAttribute("usuario", userInstance?.id)
            println("Sucesso!")
        }

        render( view: "/task/index", model: [userIntanceName: userInstance])
    }

    def usuarioSessao(Long id){
        def user = User.get(id)
        session['userId'] = user?.id
        session['username'] = user?.nome
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
