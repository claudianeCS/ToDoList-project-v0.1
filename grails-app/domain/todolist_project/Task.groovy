package todolist_project

class Task {

    User usuario
    String tarefa
    Boolean pessoal
    Boolean negocio

    static constraints = {
        tarefa(nullable: true)
    }

}
