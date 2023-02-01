use furama_resort;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
-- join 2 bảng nhân viên và hợp đồng
-- hiểnt hị những người chưa lập hợp đồng
-- select nhan_vien.ma_nhan_vien, nhan_vien.ho_ten
-- from nhan_vien
-- where nhan_vien.ma_nhan_vien not in (
-- select hop_dong.ma_nhan_vien
-- from hop_dong
-- where (year(hop_dong.ngay_lam_hop_dong) like "2019,2020,2021") 
-- );
-- xoá 5 người trên
delete from nhan_vien 
where nhan_vien.ma_nhan_vien not in (
select hop_dong.ma_nhan_vien
from hop_dong
where year(hop_dong.ngay_lam_hop_dong) like "2019,2020,2021"
);

select * from nhan_vien;

-- 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond,
--  chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
set sql_safe_updates = 0;
update
  khach_hang
set
  ma_loai_khach = 1
where
  ma_khach_hang in (
    select
      ma_khach_hang
    from
      (
        select
          kh.ma_khach_hang
        from
          khach_hang kh
          join hop_dong hd on hd.ma_khach_hang = kh.ma_khach_hang
          join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
          join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
          join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
        where
          year(ngay_lam_hop_dong) = 2021
          and ma_loai_khach = 2
        group by
          kh.ma_khach_hang
        having
          sum(
            dv.chi_phi_thue + dvdk.gia * hdct.so_luong
          ) > 1000000
      ) as sua
  );
  select * from khach_hang
  left join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach;
  
  -- 18. Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
  SET FOREIGN_KEY_CHECKS=0;
delete from khach_hang where khach_hang.ma_khach_hang
in (
select hop_dong.ma_khach_hang from hop_dong
where year(hop_dong.ngay_lam_hop_dong) < 2021
);

-- 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
drop view if exists gia_update_table;
create view gia_update_table as
select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem, sum(hop_dong_chi_tiet.so_luong) as so_luong, dich_vu_di_kem.gia
from dich_vu_di_kem
join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
join hop_dong on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong 
where year(hop_dong.ngay_lam_hop_dong) = "2020"
group by dich_vu_di_kem.ma_dich_vu_di_kem
having sum(hop_dong_chi_tiet.so_luong) > 10;

select * from gia_update_table;

-- Dịch vụ sau đây sẽ tăng giá lên gấp đôi:
update dich_vu_di_kem set dich_vu_di_kem.gia = dich_vu_di_kem.gia * 2
where dich_vu_di_kem.ma_dich_vu_di_kem
 in (select dich_vu_di_kem.ma_dich_vu_di_kem from gia_update_table);
 
 -- 20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống,
 -- thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
 
 select ma_nhan_vien as id,ho_ten,email,so_dien_thoai,ngay_sinh,dia_chi 
 from nhan_vien
 group by nhan_vien.ma_nhan_vien
 union all
 select ma_khach_hang, ho_ten, email,so_dien_thoai,ngay_sinh,dia_chi
 from khach_hang
 group by khach_hang.ma_khach_hang
 

