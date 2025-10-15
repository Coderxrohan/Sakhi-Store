package com.sakhi.store.service.impl;
import com.sakhi.store.model.Order;
import com.sakhi.store.model.Product;
import com.sakhi.store.model.User;
import com.sakhi.store.repository.OrderRepository;
import com.sakhi.store.repository.ProductRepository;
import com.sakhi.store.repository.UserRepository;
import com.sakhi.store.service.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Override
    public Order createOrder(Order order) {
        Product product = productRepository.findById(order.getProduct().getId()).orElseThrow(() -> new RuntimeException("Product not found"));
        User user = userRepository.findById(order.getUser().getId()).orElseThrow(() -> new RuntimeException("User not found"));

        if (product.getQuantity() < order.getQuantity()) throw new RuntimeException("Insufficient stock");
        product.setQuantity(product.getQuantity() - order.getQuantity());
        productRepository.save(product);

        order.setTotalAmount(product.getPrice() * order.getQuantity());
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("CREATED");
        order.setProduct(product);
        order.setUser(user);
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrdersByUser(Long userId) { return orderRepository.findByUserId(userId); }
}
