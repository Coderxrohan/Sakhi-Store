package com.sakhi.store.service.interfaces;
import com.sakhi.store.model.Order;
import java.util.List;
public interface OrderService {
    Order createOrder(Order order);
    List<Order> getOrdersByUser(Long userId);
}
