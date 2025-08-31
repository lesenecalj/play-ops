package com.playops.controller;

import com.playops.domain.StoreItem;
import com.playops.dto.CreateItemRequest;
import com.playops.dto.UpdateItemRequest;
import com.playops.services.StoreService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/stores")
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/items")
    public List<StoreItem> all() {return storeService.all();}

    @PostMapping("/items")
    public ResponseEntity<StoreItem> create(@Valid @RequestBody CreateItemRequest req) {
        StoreItem storeItem = storeService.create(req.name(), req.price());
        return ResponseEntity.status(201).body(storeItem);
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<StoreItem> update(@PathVariable("id") UUID id, @Valid @RequestBody UpdateItemRequest req) {
        StoreItem item = storeService.update(id, req.name(), req.price());
        return ResponseEntity.ok(item);
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<StoreItem> delete(@PathVariable UUID id) {
        storeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
