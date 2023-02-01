use furama_resort;

-- 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” 
-- và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
select * from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
join khach_hang on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
where loai_khach.ten_loai_khach = "Diamond" 
and (khach_hang.dia_chi like "%Vinh" or khach_hang.dia_chi like "&Quảng Ngãi")
;

-- 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng)
-- , ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc 
-- của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 
-- nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.
select hop_dong.ma_hop_dong, nhan_vien.ho_ten as ho_ten_nhan_vien, khach_hang.ho_ten as ho_ten_khach_hang, khach_hang.so_dien_thoai, dich_vu.ten_dich_vu
, hop_dong.tien_dat_coc
from hop_dong
left join nhan_vien on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
left join khach_hang on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang 
left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
left join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
-- của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 
where quarter(hop_dong.ngay_lam_hop_dong) = 4 and year(hop_dong.ngay_lam_hop_dong) = 2020
-- nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.
and hop_dong.ngay_lam_hop_dong not in (
select hop_dong.ngay_lam_hop_dong
from hop_dong
join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu

where quarter(hop_dong.ngay_lam_hop_dong) in (1,2) and year(hop_dong.ngay_lam_hop_dong) = "2021" 
)
group by hop_dong.ma_hop_dong
;


-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem,  sum(hop_dong_chi_tiet.so_luong) as so_luong_dich_vu_di_kem
from dich_vu_di_kem
join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
group by hop_dong_chi_tiet.ma_dich_vu_di_kem
having sum(hop_dong_chi_tiet.so_luong) >= all (
select sum(hop_dong_chi_tiet.so_luong) from hop_dong_chi_tiet
group by hop_dong_chi_tiet.ma_dich_vu_di_kem
)
;

-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem
-- , so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).
SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));
select  hop_dong.ma_hop_dong, loai_dich_vu.ten_loai_dich_vu, dich_vu_di_kem.ten_dich_vu_di_kem
, count(dich_vu_di_kem.ma_dich_vu_di_kem) as so_lan_su_dung
from dich_vu_di_kem
join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
group by dich_vu_di_kem.ma_dich_vu_di_kem
having count(dich_vu_di_kem.ma_dich_vu_di_kem) = 1
order by hop_dong.ma_hop_dong
;

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai
-- , dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
 SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));
select nhan_vien.ma_nhan_vien, nhan_vien.ho_ten as ho_ten_nhan_vien, trinh_do.ma_trinh_do, bo_phan.ten_bo_phan
, nhan_vien.so_dien_thoai, nhan_vien.dia_chi
from nhan_vien
join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
left join trinh_do on trinh_do.ma_trinh_do = nhan_vien.ma_trinh_do
left join bo_phan on bo_phan.ma_bo_phan = nhan_vien.ma_bo_phan
where hop_dong.ngay_lam_hop_dong between "2020-01-01" and "2021-12-31"
group by hop_dong.ma_nhan_vien
-- mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021
having count(hop_dong.ma_nhan_vien) <= 3 
order by nhan_vien.ma_nhan_vien
;