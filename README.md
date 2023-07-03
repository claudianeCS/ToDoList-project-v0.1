### TODO-LIST Project 

## Abouth

 A Todo-list project for study using a Grails framework.

# Technologies:
* MariaDB 
* Grails - 2.5.6

# Actions
* Create 
* Read
* Update 
* Delete

# Using this project:

* Install grails framework and using a MariaDb database, using this schema:

>create or replace table user
(
    id      bigint auto_increment
        primary key,
    version bigint       not null,
    nome    varchar(255) not null
);

create or replace table task
(
    id         bigint auto_increment
        primary key,
    version    bigint       not null,
    categoria  varchar(255) not null,
    tarefa     varchar(255) null,
    usuario_id bigint       not null,
    constraint FK_ieybpna9brl1ypirh49b1640i
        foreign key (usuario_id) references user (id)
);
