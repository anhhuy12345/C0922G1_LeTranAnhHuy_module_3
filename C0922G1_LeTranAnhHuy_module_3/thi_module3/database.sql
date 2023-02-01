create database bai_thi_module3;
use bai_thi_module3;

set foreign_key_checks = 0;
set sql_safe_updates = 0;

set foreign_key_checks = 0;
set sql_safe_updates = 0;

-- drop table book;
create table if not exists book(
book_id varchar(25) primary key,
book_name varchar(25),
book_author varchar(25),
book_describe varchar(25),
book_quantity int
);
insert into book(book_id,book_name, book_author, book_describe, book_quantity) values 
("S001", "Sách 1", "Thắng", "hay", 10),
("S003", "Sách 4", "Thắng2", "hay1", 10),
("S004", "Sách 1", "Thắng3", "hay3", 14),
("S002", "Sách 3", "Thắn4", "hay4", 12);


-- drop table student;
create table if not exists student(
student_id varchar(25) primary key,
student_name varchar(25),
student_class varchar(25)
); 
insert into student(student_id,student_name, student_class) values 
("SV-11", "Thanh1", "lớp 2"),
("SV-21", "Thanh3", "lớp 2"),
("SV-31", "Thanh1", "lớp 3"),
("SV-41", "Thanh3", "lớp 1");


-- drop table ground;
create table if not exists `book_borrow_card`(
book_borrow_card_id varchar(25) primary key,
book_id varchar(25),
student_id varchar(25),
book_borrow_card_status bit,
book_borrow_card_start_date date,
book_borrow_card_end_date date,


constraint fk_book_id foreign key (book_id) references book(book_id) on delete cascade,
constraint fk_student_id foreign key (student_id) references student(student_id) on delete cascade
);

insert into book_borrow_card(book_borrow_card_id,book_id, student_id, book_borrow_card_status, book_borrow_card_start_date,book_borrow_card_end_date) values 
("uu11", "ss", "sâ", 1, "2022/10/10", "2022/10/11"),
("uu12", "ss1", "sâ", 1, "2022/10/10", "2022/10/11"),
("uu13", "ss2", "sâ", 0, "2022/10/10", "2022/10/11");
