package com.playops.domain;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@ToString
public class StoreItem {
    private UUID id;
    private String name;
    private BigDecimal price;

    public StoreItem() {
        this.id = UUID.randomUUID();
    }

    public StoreItem(String name, BigDecimal price) {
        this();
        setName(name);
        setPrice(price);
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        this.name = name.trim();
    }

    public void setPrice(BigDecimal price) {
        if (price == null || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price must be non-negative");
        }
        this.price = price;
    }
}