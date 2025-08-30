package com.playops.services;

import com.playops.domain.GameParams;
import com.playops.repository.GameParamsRepository;
import org.springframework.stereotype.Service;

@Service
public class GameParamsService {
    private final GameParamsRepository repo;

    public GameParamsService(GameParamsRepository repo) { this.repo = repo; }

    public GameParams getParams() { return repo.get(); }

    public GameParams updateXpMultiplier(double xp) {
        GameParams p = repo.get();
        p.setXpMultiplier(xp);
        return p;
    }
}
