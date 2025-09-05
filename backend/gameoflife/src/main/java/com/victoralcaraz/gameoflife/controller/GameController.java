/*
 * Expose REST API endpoints to receive the board state and return the next generation
 */

package com.victoralcaraz.gameoflife.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victoralcaraz.gameoflife.model.GameRequest;
import com.victoralcaraz.gameoflife.model.GameResponse;
import com.victoralcaraz.gameoflife.service.GameService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class GameController {
    @Autowired
    private GameService gameService;

    @PostMapping("/next-generation")
    public ResponseEntity<GameResponse> getNextGeneration(@RequestBody GameRequest boardRequested){
        int[][] nextGeneration = gameService.getNextGeneration(boardRequested.getBoard());
        return ResponseEntity.ok(new GameResponse(nextGeneration));
    }
}

