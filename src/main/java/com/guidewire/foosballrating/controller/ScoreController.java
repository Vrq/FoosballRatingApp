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
    public void getAllScoreForPlayer(@RequestParam("score") Score score) {
        scoreService.insertScore(score);
    }

    @RequestMapping(value = "/allScoresForPlayer", method = RequestMethod.GET)
    public List<Score> getAllScoreForPlayer(@RequestParam("playerName") String playerName) {
        return scoreService.getAllScoreForPlayer(playerName);
    }

    @RequestMapping(value = "/latestScoreForPlayer", method = RequestMethod.GET)
    public Score getLatestScoreForPlayer(@RequestParam("playerName") String playerName) {
        return scoreService.getLatestScoreForPlayer(playerName);
    }

    @RequestMapping(value = "/scoreForPlayerInTime", method = RequestMethod.GET)
    public List<Score> getScoreForPlayerInTime(@RequestParam("playerName") String playerName, @RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {
        return scoreService.getScoreForPlayerInTime(playerName, startDate, endDate);
    }
}
