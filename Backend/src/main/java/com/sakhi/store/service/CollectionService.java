package com.sakhi.store.catalog.service;

import com.sakhi.store.catalog.dto.CollectionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CollectionService {
    CollectionDto create(String name);
    CollectionDto update(Long id, String name);
    CollectionDto get(Long id);
    void delete(Long id);
    Page<CollectionDto> list(Pageable pageable);
}
