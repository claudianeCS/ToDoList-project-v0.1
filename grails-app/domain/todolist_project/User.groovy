package todolist_project

class User {

    String nome;
     static hasMany = [task : Task]

    static constraints = {
    }
}
