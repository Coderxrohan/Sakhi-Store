package com.sakhi.store.catalog.service;

import com.sakhi.store.catalog.dto.CategoryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    CategoryDto create(String name);
    CategoryDto update(Long id, String name);
    CategoryDto get(Long id);
    void delete(Long id);
    Page<CategoryDto> list(Pageable pageable);
}
