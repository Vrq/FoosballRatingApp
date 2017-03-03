package com.guidewire.foosballrating.controller;

import com.guidewire.foosballrating.domain.Player;
import com.guidewire.foosballrating.domain.Score;
import com.guidewire.foosballrating.engine.PlayerRatingCalulator;
import com.guidewire.foosballrating.engine.RatingCalculator;
import com.guidewire.foosballrating.service.PlayerService;
import com.guidewire.foosballrating.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayersController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private ScoreService scoreService;

    private RatingCalculator ratingCalculator = new PlayerRatingCalulator();

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public Player getPlayer(@RequestParam("id") int id) {
        return playerService.getPlayer(id);
    }

    @RequestMapping(value = "/getByUsername", method = RequestMethod.GET)
    public Player getPlayer(@RequestParam("username") String username) {
        return playerService.getPlayer(username);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @RequestMapping(value = "/insertPlayer", method = RequestMethod.POST)
    public void insertPlayer(@RequestParam("player") Player player) {
        int points = ratingCalculator.startingRating();

        player.setPoints(points);
        playerService.insertPlayer(player);

        Score score = new Score();
        score.setUsername(player.getUsername());
        score.setPoints(points);
        score.setCreationTime(new Date());
        scoreService.insertScore(score);
    }

    @RequestMapping(value = "/updatePlayer", method = RequestMethod.POST)
    public void updatePlayer(@RequestParam("player") Player player) {
        playerService.updatePlayer(player);
    }
}
