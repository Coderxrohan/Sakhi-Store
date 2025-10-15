package com.sakhi.store.controller;
import com.sakhi.store.dto.request.OrderRequest;
import com.sakhi.store.model.Order;
import com.sakhi.store.model.Product;
import com.sakhi.store.model.User;
import com.sakhi.store.payload.ApiResponse;
import com.sakhi.store.service.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest req, @RequestParam Long userId) {
        Order o = new Order();
        Product p = new Product(); p.setId(req.getProductId());
        User u = new User(); u.setId(userId);
        o.setProduct(p); o.setUser(u); o.setQuantity(req.getQuantity());
        Order created = orderService.createOrder(o);
        return ResponseEntity.ok(new ApiResponse(true, "Order created", mapper.map(created, com.sakhi.store.dto.response.OrderResponse.class)));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getOrders(@PathVariable Long userId) {
        List<Order> list = orderService.getOrdersByUser(userId);
        return ResponseEntity.ok(new ApiResponse(true, "Orders fetched", list));
    }
}
