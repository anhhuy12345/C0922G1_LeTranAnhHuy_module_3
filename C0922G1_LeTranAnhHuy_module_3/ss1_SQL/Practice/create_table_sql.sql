create database student_manager;
use student_manager;

create table student(
id int,
`name` varchar(50),
age int,
country varchar(50)
);
insert into student (id,`name`,age,country) 
value(1, 'Huy', 26, 'Viet Nam'),
(2, 'Hoang', 20, 'Viet Nam');
select * from student;