package com.playops.domain;

public class GameParams {
    private double xpMultiplier = 1.0;

    public GameParams() {}
    public GameParams(double xpMultiplier) { this.xpMultiplier = xpMultiplier; }

    public double getXpMultiplier() { return xpMultiplier; }
    public void setXpMultiplier(double xpMultiplier) { this.xpMultiplier = xpMultiplier; }
}