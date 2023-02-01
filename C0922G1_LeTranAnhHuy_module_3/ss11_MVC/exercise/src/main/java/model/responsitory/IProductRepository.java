package model.responsitory;

import model.bean.Product;

import java.util.List;

public interface IProductRepository {
    //        Hiển thị danh sách sản phẩm
    List<Product> findAll();

    //        Tạo sản phẩm mới
    void save(Product product);

    //        Cập nhật thông tin sản phẩm
    void update(int id, Product product);

    //        Xoá một sản phẩm
    void remove(int id);

    //        Tìm kiếm sản phẩm theo tên
    Product findByName(String name);

    //        Xem chi tiết một sản phẩm
    Product findById(int id);
}
