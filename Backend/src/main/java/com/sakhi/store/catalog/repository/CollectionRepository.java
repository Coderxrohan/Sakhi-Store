package com.sakhi.store.catalog.repository;

import com.sakhi.store.catalog.entity.CollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionRepository extends JpaRepository<CollectionEntity, Long> {
    boolean existsByName(String name);
}
