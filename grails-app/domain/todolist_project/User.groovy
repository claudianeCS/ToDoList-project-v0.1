package todolist_project

class User {

    String nome;
    String email;
    String password
     static hasMany = [task : Task]

    static constraints = {
        password(unique: true)
    }

    static namedQueries = {
        porNome { nomeString ->
            eq 'nome', nomeString
        }
    }

}
