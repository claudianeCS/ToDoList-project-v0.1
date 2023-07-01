package todolist_project

class User {

    String nome;
     static hasMany = [task : Task]

    static constraints = {
    }

    static namedQueries = {
        porNome { nomeString ->
            eq 'nome', nomeString
        }
    }

}
