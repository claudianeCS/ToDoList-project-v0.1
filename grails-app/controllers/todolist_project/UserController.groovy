package todolist_project



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

        if (userInstance.hasErrors()) {
            render "Error no nome de usuario", status: 500
            return
        }

        userInstance.save flush:true
        usuarioSessao(userInstance?.id)

        render( view: "/task/index", model: [userIntanceName: userInstance])
    }

    def usuarioSessao(Long id){
        def user = User.get(id)
        session['userId'] = user?.id
        session['username'] = user?.nome
    }



}
