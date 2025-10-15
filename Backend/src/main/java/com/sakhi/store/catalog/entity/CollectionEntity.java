package com.sakhi.store.catalog.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "collections")
public class CollectionEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(nullable = false, unique = true)
   private String name;

   @ManyToMany(mappedBy = "collections")
   private Set<Product> products = new HashSet<>();

   public CollectionEntity() {}
   // getters setters
}
