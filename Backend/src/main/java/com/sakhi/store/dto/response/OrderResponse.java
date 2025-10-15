package com.sakhi.store.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class OrderResponse {
    private Long id;
    private Integer quantity;
    private Double totalAmount;
    private String status;
    private LocalDateTime orderDate;
    private Long productId;
    private Long userId;
}
