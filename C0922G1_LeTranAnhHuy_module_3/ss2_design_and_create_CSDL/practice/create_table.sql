create database quan_ly_diem_thi;
use quan_ly_diem_thi;

create table hoc_sinh(
ma_hoc_sinh varchar(20) primary key,
ten_hs varchar(45),
ngay_sinh datetime,
lop varchar(20),
gt varchar(20)
);

create table mon_hoc(
ma_mon_hoc varchar(20) primary key,
ten_mon_hoc varchar(20)
);

create table bang_diem(
ma_hoc_sinh varchar(20),
ma_mon_hoc varchar(20),
diem_thi int,
ngay_thi datetime,
primary key(ma_hoc_sinh, ma_mon_hoc),
foreign key(ma_hoc_sinh) references hoc_sinh(ma_hoc_sinh),
foreign key (ma_mon_hoc) references mon_hoc(ma_mon_hoc)
);

create table giao_vien(
ma_giao_vien varchar(20) primary key,
ten_giao_vien varchar(45),
so_dien_thoai varchar(45)
);

alter table mon_hoc add ma_giao_vien varchar(20);
alter table mon_hoc add constraint fk_ma_giao_vien foreign key (ma_giao_vien) references giao_vien(ma_giao_vien);
