package com.playops.services;

import com.playops.components.LiveBroadcaster;
import com.playops.domain.StoreItem;
import com.playops.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class StoreService {
    private final StoreRepository repo;
    private final LiveBroadcaster broadcaster;

    public StoreService(LiveBroadcaster liveBroadcaster, StoreRepository repo) {
        this.repo = repo;
        this.broadcaster = liveBroadcaster;
    }

    public List<StoreItem> all() {
        return repo.findAll();
    }

    public StoreItem create(String name, BigDecimal price) {
        StoreItem storedItem =  repo.save(new StoreItem(name, price));
        broadcaster.broadcast(Map.of(
                "event", "STORE_ITEM_CREATED",
                "item", storedItem
        ));
        return storedItem;
    }

    public StoreItem update(UUID id, String name, BigDecimal price) {
        StoreItem item = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Item not found"));
        item.setName(name);
        item.setPrice(price);

        StoreItem itemUpdated = repo.save(item);
        broadcaster.broadcast(Map.of(
                "event", "STORE_ITEM_UPDATED",
                "item", itemUpdated
        ));
        return itemUpdated;
    }

    public void delete(UUID id) {
        repo.delete(id);
        broadcaster.broadcast(Map.of(
                "event", "STORE_ITEM_DELETED",
                "id", id
        ));
    }
}
