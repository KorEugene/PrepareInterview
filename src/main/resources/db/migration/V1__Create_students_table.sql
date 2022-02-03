create table if not exists students (
id bigserial primary key,
name varchar(255) not null,
age integer not null
);

insert into students (name, age)
values ('Mike', 20),
       ('John', 22),
       ('Megan', 19);