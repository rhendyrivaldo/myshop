package id.shop.MyShop.service;

import id.shop.MyShop.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getProducts();
    Product getProduct(long id);
    Product createProduct(Product product);
    void deleteProduct(long id);
}
