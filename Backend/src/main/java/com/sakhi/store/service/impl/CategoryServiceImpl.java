package com.sakhi.store.catalog.service.impl;

import com.sakhi.store.catalog.dto.CategoryDto;
import com.sakhi.store.catalog.entity.Category;
import com.sakhi.store.catalog.repository.CategoryRepository;
import com.sakhi.store.exception.NotFoundException;
import com.sakhi.store.exception.BadRequestException;
import com.sakhi.store.catalog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repo;

    @Autowired
    public CategoryServiceImpl(CategoryRepository repo) { this.repo = repo; }

    @Override
    public CategoryDto create(String name) {
        if (name == null || name.trim().isEmpty()) throw new BadRequestException("Category name required");
        if (repo.existsByName(name.trim())) throw new BadRequestException("Category already exists");
        Category c = new Category();
        c.setName(name.trim());
        Category saved = repo.save(c);
        return new CategoryDto(saved.getId(), saved.getName());
    }

    @Override
    public CategoryDto update(Long id, String name) {
        Category c = repo.findById(id).orElseThrow(() -> new NotFoundException("Category not found"));
        if (name == null || name.trim().isEmpty()) throw new BadRequestException("Category name required");
        c.setName(name.trim());
        Category saved = repo.save(c);
        return new CategoryDto(saved.getId(), saved.getName());
    }

    @Override
    public CategoryDto get(Long id) {
        Category c = repo.findById(id).orElseThrow(() -> new NotFoundException("Category not found"));
        return new CategoryDto(c.getId(), c.getName());
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) throw new NotFoundException("Category not found");
        repo.deleteById(id);
    }

    @Override
    public Page<CategoryDto> list(Pageable pageable) {
        Page<Category> p = repo.findAll(pageable);
        return p.map(c -> new CategoryDto(c.getId(), c.getName()));
    }
}
