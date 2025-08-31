package com.playops.repository;

import com.playops.domain.StoreItem;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class StoreRepository {
    private final Map<UUID, StoreItem> items = new ConcurrentHashMap<>();

    public List<StoreItem> findAll() { return new ArrayList<>(items.values()); }
    public Optional<StoreItem> findById(UUID id) { return Optional.ofNullable(items.get(id)); }
    public StoreItem save(StoreItem item) { items.put(item.getId(), item); return item; }
    public void delete(UUID id) { items.remove(id); }
}