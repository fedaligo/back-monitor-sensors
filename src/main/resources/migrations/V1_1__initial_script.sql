create table sensors
(
    id          serial not null
        constraint sensors_pk
            primary key,
    name        varchar(30),
    model       varchar(15),
    rangefrom   integer,
    rangeto     integer,
    type        varchar(20),
    unit        varchar(10),
    location    varchar(40),
    description varchar(200)
);

alter table sensors
    owner to test;

create unique index sensors_id_uindex
    on sensors (id);

create table users
(
    id       serial not null
        constraint users_pk
            primary key,
    name     varchar(30),
    role     varchar(30),
    password varchar(30)
);

alter table users
    owner to test;

create unique index users_id_uindex
    on users (id);

create table type
(
    id   serial not null
        constraint type_pk
            primary key,
    name varchar(20)
);

alter table type
    owner to test;

create unique index type_id_uindex
    on type (id);

create unique index type_name_uindex
    on type (name);

create table unit
(
    id   serial not null
        constraint unit_pk
            primary key,
    name varchar(10)
);

alter table unit
    owner to test;

create unique index unit_id_uindex
    on unit (id);

create unique index unit_name_uindex
    on unit (name);

