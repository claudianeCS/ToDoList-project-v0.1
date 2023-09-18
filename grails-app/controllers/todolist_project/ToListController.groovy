package todolist_project

import todolist_project.sec.Usuario

class ToListController {

    def springSecurityService

    def logar(){
        render(view: "/toList/logar")
    }
    def admin(){
        String usuario = springSecurityService.principal.username
        def usuarioId = Usuario.findByUsername(usuario)
        session['userId'] = usuarioId.id
        session.setMaxInactiveInterval(1200)
        render(view: '/task/index', model: [usuario: usuario])
    }

    def logout(){
        if (session['userId']){
            def user = Usuario.get(session['userId'])
            user.delete()
        }
        redirect(action: 'logar')
    }
}
