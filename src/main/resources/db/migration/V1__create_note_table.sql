create table if not exists notes (
    id int primary key,
    title varchar(100) not null,
    content varchar(255)
);