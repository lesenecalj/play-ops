package com.playops.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

public record UpdateGameParamsRequest(
        @Min(1) @Max(10) @Positive double xpMultiplier
) {
}