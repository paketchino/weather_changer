create table if not exists roles (
    id serial primary key,
    name varchar not null unique
);

create table if not exists users (
    id serial primary key,
    email varchar not null unique,
    password varchar,
    role_id int not null references roles(id)
);