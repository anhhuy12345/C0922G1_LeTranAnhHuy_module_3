create database material_management;
use material_management;

-- tao bang phieu xuat
create table phieu_xuat (
so_px int primary key,
ngay_xuat datetime
); 
-- tao bang vat tu 
create table vat_tu (
ma_vat_tu int primary key ,
ten_vat_tu varchar(100)
);  
-- tao bang chi_tiet_phieu_xuat 


create table  chi_tiet_phieu_xuat  (
so_px int,
ma_vat_tu int,
primary key (so_px,ma_vat_tu),
don_gia_xuat double not null,
so_luong_xuat bigint,
foreign key(so_px) references phieu_xuat(so_px),
foreign key(ma_vat_tu) references vat_tu(ma_vat_tu)
);

-- tao bang phieu_nhap 
create table phieu_nhap(
so_phieu_nhap int primary key,
ngay_nhap date 
);
 -- tao bang chi tiet phieu nhap 
  create table chi_tiet_phieu_nhap (
  ma_vat_tu int,
  so_phieu_nhap int ,
  don_gia_nhap double,
  so_luong_nhap int,
  primary key(ma_vat_tu,so_phieu_nhap),
  foreign key(ma_vat_tu) references vat_tu(ma_vat_tu),
  foreign key(so_phieu_nhap) references phieu_nhap(so_phieu_nhap)
 );
 
 -- tao bang don_dat_hang
 create table don_dat_hang (
 so_don_hang int  primary key ,
 ngay_don_hang date,
 ma_nha_cung_cap int,
 foreign key(ma_nha_cung_cap) references nha_cung_cap(ma_nha_cung_cap)
 );
 -- tao bang chi_tiet_don_dat_hang 
 create table chi_tiet_don_dat_hang (
  ma_vat_tu int,
  so_don_hang int,
 primary key(ma_vat_tu,so_don_hang),
 foreign key(ma_vat_tu) references vat_tu(ma_vat_tu),
 foreign key(so_don_hang) references don_dat_hang(so_don_hang)
 );
 
  --  tao bang nha_cung_cap
  create table nha_cung_cap (
  ma_nha_cung_cap int primary key,
  ten_nha_cung_cap varchar(120),
  dia_chi varchar(120),
  so_dien_thoai int 
  );