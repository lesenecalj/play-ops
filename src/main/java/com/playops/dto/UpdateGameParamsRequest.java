package com.playops.dto;

import jakarta.validation.constraints.Positive;

public class UpdateGameParamsRequest {
    @Positive
    private double xpMultiplier;

    public UpdateGameParamsRequest() {}
    public UpdateGameParamsRequest(double xpMultiplier) { this.xpMultiplier = xpMultiplier; }

    public double getXpMultiplier() { return xpMultiplier; }
    public void setXpMultiplier(double xpMultiplier) { this.xpMultiplier = xpMultiplier; }
}