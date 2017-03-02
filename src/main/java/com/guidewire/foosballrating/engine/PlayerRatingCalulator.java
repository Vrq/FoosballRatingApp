package com.guidewire.foosballrating.engine;


import com.guidewire.foosballrating.domain.Game;
import com.guidewire.foosballrating.domain.Player;

public class PlayerRatingCalulator implements RatingCalculator {

    @Override
    public int startingRating() {
        return 100;
    }

    public int calcuatePlayerRating(Player player, Game game) {
        return 123;
    }
}
