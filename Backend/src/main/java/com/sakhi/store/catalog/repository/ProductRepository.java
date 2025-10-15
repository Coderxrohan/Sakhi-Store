package com.sakhi.store.catalog.repository;

import com.sakhi.store.catalog.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByCategoryId(Long categoryId, Pageable pageable);

    @Query("select p from Product p join p.collections c where c.id = :collectionId")
    Page<Product> findByCollectionId(@Param("collectionId") Long collectionId, Pageable pageable);
}
