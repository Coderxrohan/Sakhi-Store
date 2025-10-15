public package com.sakhi.store.catalog.controller;

import com.sakhi.store.catalog.dto.CollectionDto;
import com.sakhi.store.catalog.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/api/catalog/collections")
public class CollectionController {

    private final CollectionService service;

    @Autowired
    public CollectionController(CollectionService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<CollectionDto> create(@RequestBody CollectionDto req) {
        CollectionDto dto = service.create(req.getName());
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CollectionDto> update(@PathVariable Long id, @RequestBody CollectionDto req) {
        return ResponseEntity.ok(service.update(id, req.getName()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CollectionDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<CollectionDto>> list(
        @RequestParam(defaultValue = "0") @Min(0) int page,
        @RequestParam(defaultValue = "20") @Min(1) int size
    ){
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        return ResponseEntity.ok(service.list(pageable));
    }
}
 {
    
}
