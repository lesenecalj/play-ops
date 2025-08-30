package com.playops.repository;

import com.playops.domain.GameParams;

public class GameParamsRepository {
    private final GameParams params = new GameParams(1.0);

    public GameParams get() {
        return params;
    }
}
