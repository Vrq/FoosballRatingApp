package com.guidewire.foosballrating.service;

import com.guidewire.foosballrating.domain.Game;
import com.guidewire.foosballrating.domain.Player;
import com.guidewire.foosballrating.domain.Score;
import com.guidewire.foosballrating.engine.PlayerRatingCalulator;
import com.guidewire.foosballrating.engine.RatingCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    PlayerService playerService;

    @Autowired
    ScoreService scoreService;

    RatingCalculator ratingCalculator = new PlayerRatingCalulator();

    @Override
    public void updateRatings(Game game) {
        Player aPlayer1 = playerService.getPlayer(game.getaPlayer1());
        updatePlayerStats(aPlayer1, game.getaScore(), game.getbScore());

        Player aPlayer2 = playerService.getPlayer(game.getaPlayer2());
        updatePlayerStats(aPlayer2, game.getaScore(), game.getbScore());

        Player bPlayer1 = playerService.getPlayer(game.getbPlayer1());
        updatePlayerStats(bPlayer1, game.getbScore(), game.getaScore());

        Player bPlayer2 = playerService.getPlayer(game.getbPlayer2());
        updatePlayerStats(bPlayer2, game.getbScore(), game.getaScore());

        updatePlayerRating(aPlayer1, game);
        updatePlayerRating(aPlayer2, game);
        updatePlayerRating(bPlayer1, game);
        updatePlayerRating(bPlayer2, game);
    }

    private void updatePlayerRating(Player player, Game game) {
        player.setPoints(ratingCalculator.calcuatePlayerPoints(player, game));
        playerService.updatePlayer(player);
        int rank = playerService.getAllPlayers().lastIndexOf(player) + 1;
        Score score = new Score(player.getUsername(), rank , player.getPoints());
        scoreService.insertScore(score);
    }

    private void updatePlayerStats(Player player, Integer setsWon, Integer setsLost) {
        Integer updatedSetsWon = Optional.ofNullable(player.getSetsWon()).orElse(0) + setsWon;
        Integer updatedSetsLost = Optional.ofNullable(player.getSetsLost()).orElse(0) + setsLost;

        player.setSetsWon(updatedSetsWon);
        player.setSetsLost(updatedSetsLost);

        if (setsWon > setsLost) { // Win
            player.setGamesWon((Optional.ofNullable(player.getGamesWon()).orElse(0) + 1));
        }

        if (setsWon < setsLost) { // Lose
            player.setGamesLost((Optional.ofNullable(player.getGamesLost()).orElse(0) + 1));
        }

        // Draw
    }
}
