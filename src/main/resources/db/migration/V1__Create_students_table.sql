create table if not exists students (
id bigserial primary key,
name varchar(255) not null,
mark integer
);