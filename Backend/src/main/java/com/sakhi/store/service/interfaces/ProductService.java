package com.sakhi.store.service.interfaces;
import com.sakhi.store.model.Product;
import java.util.List;
public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    List<Product> getProductsByUser(Long userId);
}
