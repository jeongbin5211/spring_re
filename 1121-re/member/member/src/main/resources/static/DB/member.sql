use koreaitdb;

create table member(
id int not null auto_increment,
email varchar(50) not null,
passwd varchar(20) not null,
name varchar(10) not null,
regdate date,
primary key(id)
);