package com.playops.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UpdateItemRequest(
        @NotBlank
        String name,
        @Min(0)
        BigDecimal price
) {
}
