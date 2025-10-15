package com.sakhi.store.service.impl;
import com.sakhi.store.model.Product;
import com.sakhi.store.model.User;
import com.sakhi.store.repository.ProductRepository;
import com.sakhi.store.repository.UserRepository;
import com.sakhi.store.service.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Override
    public Product createProduct(Product product) {
        if (product.getUser() != null && product.getUser().getId() != null) {
            User user = userRepository.findById(product.getUser().getId()).orElseThrow(() -> new RuntimeException("User not found"));
            product.setUser(user);
        }
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product e = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        e.setName(product.getName());
        e.setDescription(product.getDescription());
        e.setPrice(product.getPrice());
        e.setQuantity(product.getQuantity());
        e.setCategory(product.getCategory());
        return productRepository.save(e);
    }

    @Override
    public void deleteProduct(Long id) { productRepository.deleteById(id); }

    @Override
    public List<Product> getProductsByUser(Long userId) { return productRepository.findByUserId(userId); }
}
