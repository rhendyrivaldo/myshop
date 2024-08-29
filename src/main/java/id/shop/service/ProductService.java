package id.shop.service;

import id.shop.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    List<Product> createProducts();
}
