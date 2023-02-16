drop
database if exists test;

create
database test;

use
test;

drop table if exists test_user;

create table test_user
(
    id       int auto_increment primary key,
    name     varchar(255) not null default 'user',
    password varchar(255) not null default 'QvQ',
    birthday date,
    email    varchar(255)
);

insert into test_user(name, password, birthday, email)
values ('a', '123456', '1985-09-11', 'test_1@test.example');

insert into test_user(name, password, birthday, email)
values ('b', '7891011', '1986-09-11', 'test_2@test.example');

insert into test_user(name, password, birthday, email)
values ('c', 'simple_password', '2000-09-11', 'test_3@test.example');

insert into test_user(name, password, birthday, email)
values ('d', 'what', '2001-09-11', 'test_4@test.example');
