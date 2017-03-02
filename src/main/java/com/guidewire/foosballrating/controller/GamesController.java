package com.guidewire.foosballrating.controller;

import com.guidewire.foosballrating.domain.Game;
import com.guidewire.foosballrating.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GamesController {

    @Autowired
    private GameService gameService;


    @RequestMapping("/getAll")
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }
}
