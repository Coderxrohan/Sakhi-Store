package com.sakhi.store.dto.request;
import lombok.Data;
@Data
public class ProductRequest {
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private String category;
}
