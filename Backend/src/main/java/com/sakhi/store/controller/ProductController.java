package com.sakhi.store.controller;
import com.sakhi.store.dto.request.ProductRequest;
import com.sakhi.store.model.Product;
import com.sakhi.store.payload.ApiResponse;
import com.sakhi.store.service.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest req, @RequestParam Long userId) {
        Product p = mapper.map(req, Product.class);
        p.setUser(new com.sakhi.store.model.User());
        p.getUser().setId(userId);
        Product created = productService.createProduct(p);
        return ResponseEntity.ok(new ApiResponse(true, "Product created", mapper.map(created, com.sakhi.store.dto.response.ProductResponse.class)));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getByUser(@PathVariable Long userId) {
        List<Product> list = productService.getProductsByUser(userId);
        return ResponseEntity.ok(new ApiResponse(true, "Products fetched", list));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductRequest req) {
        Product p = mapper.map(req, Product.class);
        Product updated = productService.updateProduct(id, p);
        return ResponseEntity.ok(new ApiResponse(true, "Product updated", mapper.map(updated, com.sakhi.store.dto.response.ProductResponse.class)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok(new ApiResponse(true, "Product deleted", null));
    }
}
