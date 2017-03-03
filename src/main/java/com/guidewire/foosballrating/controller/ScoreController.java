package com.guidewire.foosballrating.controller;

import com.guidewire.foosballrating.domain.Score;
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
@RequestMapping("/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @RequestMapping(value = "/insertScore", method = RequestMethod.POST)
    public ResponseEntity<String> getAllScoreForPlayer(@RequestParam("score") Score score) {
        scoreService.insertScore(score);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/allScoresForPlayer", method = RequestMethod.GET)
    public ResponseEntity<List<Score>> getAllScoreForPlayer(@RequestParam("playerName") String playerName) {
        List<Score> result = scoreService.getAllScoreForPlayer(playerName);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/latestScoreForPlayer", method = RequestMethod.GET)
    public ResponseEntity<Score> getLatestScoreForPlayer(@RequestParam("playerName") String playerName) {
        Score result = scoreService.getLatestScoreForPlayer(playerName);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/scoreForPlayerInTime", method = RequestMethod.GET)
    public ResponseEntity<List<Score>> getScoreForPlayerInTime(@RequestParam("playerName") String playerName, @RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {
        List<Score> result = scoreService.getScoreForPlayerInTime(playerName, startDate, endDate);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
