package com.sakhi.store.catalog.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Set;

public class CreateProductRequest {
    @NotBlank
    private String title;
    private String description;
    @NotNull
    @DecimalMin("0.0")
    private BigDecimal price;
    private Long categoryId;
    private Set<Long> collectionIds;
    // getters setters
}
