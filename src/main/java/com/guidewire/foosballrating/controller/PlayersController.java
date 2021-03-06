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
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Player> getPlayer(@RequestParam("id") int id) {
        Player player = playerService.getPlayer(id);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @RequestMapping(value = "/getByUsername", method = RequestMethod.GET)
    public ResponseEntity<Player> getPlayer(@RequestParam("username") String username) {
        Player player = playerService.getPlayer(username);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> result = playerService.getAllPlayers();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/insertPlayer", method = RequestMethod.POST)
    public ResponseEntity<Player> insertPlayer(@RequestBody Player player) {
        if(!playerService.isUsernameAvailable(player.getUsername())){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        int points = ratingCalculator.startingRating();

        player.setPoints(points);
        playerService.insertPlayer(player);

        Score score = new Score();
        score.setUsername(player.getUsername());
        score.setPoints(points);
        score.setCreationTime(new Date());
        score.setRank(playerService.getPlayerRank(player.getUsername()));
        scoreService.insertScore(score);

        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @RequestMapping(value = "/updatePlayer", method = RequestMethod.POST)
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
        playerService.updatePlayer(player);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }
}
