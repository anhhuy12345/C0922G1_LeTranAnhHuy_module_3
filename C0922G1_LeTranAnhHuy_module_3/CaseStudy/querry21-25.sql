use furama_resort;

-- 21.	Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên 
-- có địa chỉ là “Hải Châu” và đã từng lập hợp đồng cho một hoặc nhiều khách hàng 
-- bất kì với ngày lập hợp đồng là “12/12/2019”.

drop view  v_nhan_vien;
create view v_nhan_vien as (
select nhan_vien.*, hop_dong.ngay_lam_hop_dong from nhan_vien 
join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
where nhan_vien.dia_chi like "%Liên Chiểu"
and hop_dong.ngay_lam_hop_dong = "2021-04-25"
group by hop_dong.ma_nhan_vien
having count(hop_dong.ma_nhan_vien) > 0
);

select * from v_nhan_vien;

-- 22.	Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này.
set sql_safe_updates = 0;
update nhan_vien set nhan_vien.dia_chi = "Liên Chiểu"
where nhan_vien.ma_nhan_vien in (select v_nhan_vien.ma_nhan_vien from v_nhan_vien);
select * from v_nhan_vien; 

-- 23.	Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào đó 
-- với ma_khach_hang được truyền vào như là 1 tham số của sp_xoa_khach_hang.

delimiter //
create procedure sp_xoa_khach_hang (in ma_khach_hang_xoa int)
begin 
	update khach_hang set khach_hang.flag = 0
    where khach_hang.ma_khach_hang = ma_khach_hang_xoa;
end 
// delimiter ;

call sp_xoa_khach_hang(2);

-- 24.	Tạo Stored Procedure sp_them_moi_hop_dong  
-- dùng để thêm mới vào bảng hop_dong với yêu cầu sp_them_moi_hop_dong phải thực hiện kiểm tra tính hợp lệ của dữ liệu
--  bổ sung, với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan. 

drop procedure if exists sp_them_moi_hop_dong;
delimiter //
create procedure sp_them_moi_hop_dong (ma_hop_dong_add int, ngay_lam_hop_dong_add datetime,
 ngay_ket_thuc_add datetime, tien_dat_coc_add double, ma_nhan_vien_add int, ma_khach_hang_add int, ma_dich_vu_add int)
 begin
	if ma_hop_dong_add in (select hop_dong.ma_hop_dong from hop_dong)
	then 
		select "ma_hop_dong_add nhap vao khong hop le" as `error`;
	else
		insert into hop_dong
		values (ma_hop_dong_add, ngay_lam_hop_dong_add , ngay_ket_thuc_add , tien_dat_coc_add , ma_nhan_vien_add , ma_khach_hang_add , ma_dich_vu_add);
    end if;
end
// delimiter ;
call sp_them_moi_hop_dong();

-- 25.	Tạo Trigger có tên tr_xoa_hop_dong khi xóa bản ghi trong bảng hop_dong 
-- thì hiển thị tổng số lượng bản ghi còn lại có trong bảng hop_dong ra giao diện console của database.
-- Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.

create table if not exists `history`(
ma_hop_dong int,
ngay_lam_hop_dong datetime,
ngay_ket_thuc datetime,
ngay_xoa datetime
);

drop trigger if exists tr_xoa_hop_dong;
delimiter //
create trigger tr_xoa_hop_dong
after delete 
on hop_dong for each row
begin
declare tong_so_luong_ban_ghi_con_lai int;
set tong_so_luong_ban_ghi_con_lai =  (select count(hop_dong.ma_hop_dong) from hop_dong);
insert into `history`(ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, ngay_xoa ) values(old.ma_hop_dong, old.ngay_lam_hop_dong, old.ngay_ket_thuc, now());
end 
//delimiter ;

-- check
SET FOREIGN_KEY_CHECKS=0;
delete from hop_dong where (hop_dong.ma_hop_dong = 9);
select * from history;
select * from hop_dong;

 
