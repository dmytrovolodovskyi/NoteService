create table if not exists users(
    id varchar(255) primary key,
    password_hash varchar(255) not null,
    name varchar(255) not null
);