create database if not exists demo;
drop database if exists demo;
use demo;

create table `users` (
	id int auto_increment primary key,
    `name` varchar(50) ,
    email varchar(50) ,
    country varchar(50) 
);
    
insert into users(`name`,email,country) 
values
	('Minh','duy@gmail.com','viet nam'),
	('Nhan','abc@gmail.com','Japan');

select * from users;