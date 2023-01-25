create table if not exists sensors (
    id serial primary key,
    name varchar not null unique
);

create table if not exists countries (
    id serial primary key,
    name varchar not null unique
);

create table if not exists cities (
    id serial primary key,
    oblast text not null unique,
    name text not null unique
);

create table if not exists streets (
    id serial primary key,
    name text not null unique,
    country_id int not null references countries(id),
    city_id int not null references cities(id),
    index text unique not null
);

create table if not exists measurements (
    id serial primary key,
    raining boolean,
    value double precision,
    sensor_id int not null references sensors(id),
    street_id int not null references streets(id),
    start timestamp not null default current_timestamp,
    finish timestamp not null
);
