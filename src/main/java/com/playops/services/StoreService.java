package com.playops.services;

import com.playops.domain.StoreItem;
import com.playops.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class StoreService {
    private final StoreRepository repo;

    public StoreService(StoreRepository repo) {
        this.repo = repo;
    }

    public List<StoreItem> all() {
        return repo.findAll();
    }

    public StoreItem create(String name, BigDecimal price) {
        return repo.save(new StoreItem(name, price));
    }

    public StoreItem update(UUID id, String name, BigDecimal price) {
        System.out.println(id);
        StoreItem item = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Item not found"));
        item.setName(name);
        item.setPrice(price);
        return repo.save(item);
    }

    public void delete(UUID id) {
        repo.delete(id);
    }
}
