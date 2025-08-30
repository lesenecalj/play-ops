package com.playops.controller;

import com.playops.domain.GameParams;
import com.playops.dto.UpdateGameParamsRequest;
import com.playops.services.GameParamsService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class GameParamsController {
    private final GameParamsService gameParamsService;

    public GameParamsController(GameParamsService gameParamsService) {
        this.gameParamsService = gameParamsService;
    }

    @GetMapping("/params")
    public GameParams getParams() {
        return gameParamsService.getParams();
    }

    @PutMapping("/params")
    public ResponseEntity<GameParams> update(@Valid @RequestBody UpdateGameParamsRequest req) {
        GameParams updated = gameParamsService.updateXpMultiplier(req.xpMultiplier());
        return ResponseEntity.ok(updated);
    }
}
