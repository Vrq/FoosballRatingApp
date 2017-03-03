package com.guidewire.foosballrating.service;

import com.guidewire.foosballrating.domain.Game;
import com.guidewire.foosballrating.domain.Player;
import com.guidewire.foosballrating.domain.Score;
import com.guidewire.foosballrating.engine.PlayerRatingCalulator;
import com.guidewire.foosballrating.engine.RatingCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    PlayerService playerService;

    @Autowired
    ScoreService scoreService;

    RatingCalculator ratingCalculator = new PlayerRatingCalulator();

    @Override
    public void updateRatings(Game game) {
        updatePlayerRating(playerService.getPlayer(game.getaPlayer1()), game);
        updatePlayerRating(playerService.getPlayer(game.getaPlayer2()), game);
        updatePlayerRating(playerService.getPlayer(game.getbPlayer1()), game);
        updatePlayerRating(playerService.getPlayer(game.getbPlayer2()), game);
    }

    private void updatePlayerRating(Player player, Game game) {
        player.setPoints(ratingCalculator.calcuatePlayerPoints(player, game));
        playerService.updatePlayer(player);
        int rank = playerService.getAllPlayers().stream().map(e -> e.getUsername()).collect(Collectors.toList()).indexOf(player.getUsername());
        Score score = new Score(player.getUsername(), rank , player.getPoints());
        scoreService.insertScore(score);
    }
}
