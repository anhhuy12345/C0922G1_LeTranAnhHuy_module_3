create database class;
use class;

create table class(
id int primary key,
`name` varchar(50)
);

create table teacher(
id int primary key,
`name` varchar(50),
age int,
`country` varchar(50)
);
-- them phan tu
insert class(id, name)
 values(1,'Huy'),
(2,'Hoang');
select * from class;

insert teacher(id, `name`, age, `country`)
values(1, 'Son', 29, 'VietNam'),
(2, 'Cong', 30, 'Da nang');
select * from teacher;
-- sua phan tu

set SQL_SAFE_UPDATES = 0;
update teacher set name = 'Huy' where id = 2;
-- xoa phan tu
delete from teacher where id = 1;