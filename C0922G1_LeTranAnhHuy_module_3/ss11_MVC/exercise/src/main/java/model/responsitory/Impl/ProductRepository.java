package model.responsitory.Impl;

import model.bean.Product;
import model.responsitory.IProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> productList = new HashMap<>();

    static {
        productList.put(1, new Product(1, "sữa", 10000, "sua tiet trung", "Vinamilk"));
        productList.put(2, new Product(2, "banh mi", 150000, "banh mi cha", "dong tien"));
        productList.put(3, new Product(3, "banh trang tron", 20000, "5 trung", "Banh Trang Tron"));
        productList.put(4, new Product(4, "ca vien chien", 50000, "bo vien, ca vien, muc vien", "Pho Co Ha Noi"));
        productList.put(5, new Product(5, "xoi chien", 35000, "xoi chien cha bong", "Xoi Chien"));
        productList.put(6, new Product(6, "chen trung nuong", 10000, "pho mai, bo kho, trung", "Chen Trung Nuong"));
    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id, product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }

    @Override
    public Product findByName(String name) {
        for (Map.Entry<Integer, Product> productEntry : productList.entrySet()) {
            if ((productEntry.getValue().getName()).equals(name)) {
                return productEntry.getValue();
            }
        }
        return null;
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }
}
