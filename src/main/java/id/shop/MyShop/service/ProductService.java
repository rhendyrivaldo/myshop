package id.shop.MyShop.service;

import id.shop.MyShop.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Page<Product> getProducts(int page, int size);
    Product getProduct(long id);
    Product createProduct(Product product);
    void deleteProduct(long id);
}
