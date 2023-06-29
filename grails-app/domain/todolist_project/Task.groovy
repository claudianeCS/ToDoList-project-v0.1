package todolist_project

class Task {

    User usuario
    String tarefa
    String categoria

    static constraints = {
        tarefa(nullable: true)
    }

}
