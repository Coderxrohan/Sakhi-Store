package com.sakhi.store.catalog.service.impl;

import com.sakhi.store.catalog.dto.CollectionDto;
import com.sakhi.store.catalog.entity.CollectionEntity;
import com.sakhi.store.catalog.repository.CollectionRepository;
import com.sakhi.store.exception.NotFoundException;
import com.sakhi.store.exception.BadRequestException;
import com.sakhi.store.catalog.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CollectionServiceImpl implements CollectionService {

    private final CollectionRepository repo;

    @Autowired
    public CollectionServiceImpl(CollectionRepository repo) { this.repo = repo; }

    @Override
    public CollectionDto create(String name) {
        if (name == null || name.trim().isEmpty()) throw new BadRequestException("Collection name required");
        if (repo.existsByName(name.trim())) throw new BadRequestException("Collection already exists");
        CollectionEntity c = new CollectionEntity();
        c.setName(name.trim());
        CollectionEntity saved = repo.save(c);
        return new CollectionDto(saved.getId(), saved.getName());
    }

    @Override
    public CollectionDto update(Long id, String name) {
        CollectionEntity c = repo.findById(id).orElseThrow(() -> new NotFoundException("Collection not found"));
        if (name == null || name.trim().isEmpty()) throw new BadRequestException("Collection name required");
        c.setName(name.trim());
        CollectionEntity saved = repo.save(c);
        return new CollectionDto(saved.getId(), saved.getName());
    }

    @Override
    public CollectionDto get(Long id) {
        CollectionEntity c = repo.findById(id).orElseThrow(() -> new NotFoundException("Collection not found"));
        return new CollectionDto(c.getId(), c.getName());
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) throw new NotFoundException("Collection not found");
        repo.deleteById(id);
    }

    @Override
    public Page<CollectionDto> list(Pageable pageable) {
        Page<CollectionEntity> p = repo.findAll(pageable);
        return p.map(c -> new CollectionDto(c.getId(), c.getName()));
    }
}
