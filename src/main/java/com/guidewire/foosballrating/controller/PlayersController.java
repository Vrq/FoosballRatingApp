package com.guidewire.foosballrating.controller;

import com.guidewire.foosballrating.domain.Player;
import com.guidewire.foosballrating.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayersController {

    @Autowired
    private PlayerService playerService;

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
    public ResponseEntity<String> insertPlayer(@RequestParam("player") Player player) {
        playerService.insertPlayer(player);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/updatePlayer", method = RequestMethod.POST)
    public ResponseEntity<String> updatePlayer(@RequestParam("player") Player player) {
        playerService.updatePlayer(player);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
