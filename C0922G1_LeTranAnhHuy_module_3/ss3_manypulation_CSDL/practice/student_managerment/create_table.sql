create database if not exists students_management;
use students_management;

create table class(
class_id int primary key,
class_name varchar(20),
stardate date,
`status` bit
);

create table student(
student_id int primary key,
student_name varchar(45),
address varchar(45),
phone varchar(45),
`status` bit,
class_id int,
foreign key(class_id) references class(class_id)  
);

create table subjects(
sub_id int primary key,
sub_name varchar(20),
credit int,
`status` bit
);

create table mark(
mark_id int auto_increment primary key,
sub_id int,
student_id int,
mark int,
exam_times time,
foreign key( sub_id) references subjects(sub_id),
foreign key( student_id) references student(student_id)
);