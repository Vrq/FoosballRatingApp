package com.guidewire.foosballrating.controller;

import com.guidewire.foosballrating.domain.Game;
import com.guidewire.foosballrating.persistence.GameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameRestController {

    final private GameMapper gameMapper;

    public GameRestController(GameMapper cityMapper) {
        this.gameMapper = cityMapper;
    }


    @RequestMapping("/games")
    public List<Game> games() {
        return gameMapper.getAllGames();
    }
}
