create table posts (
    id serial primary key,
    name varchar(2000),
    description text,
    created timestamp without time zone not null default now()
    );

CREATE TABLE authorities (
    id serial primary key,
    authority VARCHAR(50) NOT NULL unique
);

CREATE TABLE users (
    id serial primary key,
    username VARCHAR(50) NOT NULL unique,
    password VARCHAR(100) NOT NULL,
    enabled boolean default true,
    authority_id int not null references authorities(id)
);