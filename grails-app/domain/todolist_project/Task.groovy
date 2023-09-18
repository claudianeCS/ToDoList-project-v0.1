package todolist_project

import todolist_project.sec.Usuario

class Task {

    Usuario usuario
    String tarefa
    String categoria

    static constraints = {
        tarefa(nullable: true)
    }

}
