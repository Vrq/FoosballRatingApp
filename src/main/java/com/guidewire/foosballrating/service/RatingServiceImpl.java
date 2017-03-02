package com.guidewire.foosballrating.service;

import com.guidewire.foosballrating.domain.Game;
import com.guidewire.foosballrating.domain.Player;
import com.guidewire.foosballrating.engine.PlayerRatingCalulator;
import com.guidewire.foosballrating.engine.RatingCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    PlayerService playerService;

    RatingCalculator ratingCalculator = new PlayerRatingCalulator();

    @Override
    public void updateRatings(Game game) {
        updatePlayerRating(playerService.getPlayer(game.getaPlayer1()));
        updatePlayerRating(playerService.getPlayer(game.getaPlayer2()));
        updatePlayerRating(playerService.getPlayer(game.getbPlayer1()));
        updatePlayerRating(playerService.getPlayer(game.getbPlayer2()));
    }

    private void updatePlayerRating(Player player) {
        player.setPoints(ratingCalculator.calcuatePlayerRating(player));
        playerService.updatePlayer(player);
    }
}
