package com.sakhi.store.catalog.dto;

import java.math.BigDecimal;
import java.util.Set;

public class ProductDto {
    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private Long categoryId;
    private String categoryName;
    private Set<Long> collectionIds;
    // getters & setters
}
