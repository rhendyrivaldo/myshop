package id.shop.MyShop.service;

import id.shop.MyShop.model.Product;
import id.shop.MyShop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(
        ProductRepository productRepository
    ) {
        this.productRepository = productRepository;
    }
    @Override
    public Page<Product> getProducts(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Product getProduct(long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }
}
