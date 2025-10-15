package com.sakhi.store.dto.request;
import lombok.Data;
@Data
public class OrderRequest {
    private Long productId;
    private Integer quantity;
}
