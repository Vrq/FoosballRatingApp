package com.guidewire.foosballrating.controller;

import com.guidewire.foosballrating.domain.Game;
import com.guidewire.foosballrating.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GamesController {

    @Autowired
    private GameService gameService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @RequestMapping(value = "/insertGame", method = RequestMethod.POST)
    public void insertGame(@RequestParam("game") Game game) {
        gameService.insertGame(game);
    }

}
