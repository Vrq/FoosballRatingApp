package com.guidewire.foosballrating.engine;


import com.guidewire.foosballrating.domain.Game;
import com.guidewire.foosballrating.domain.Player;

public class PlayerRatingCalulator implements RatingCalculator {

    private double diffScoreFactor = 0.15;
    private double multiplierFactor = 10;

    @Override
    public int startingRating() {
        return 100;
    }

    @Override
    public int calcuatePlayerPoints(Player player, Game game) {
        //TODO Change implementation
        return (int) Math.round(player.getPoints() + (calculateScoreFactor(game) * multiplierFactor));
    }

    private double calculateScoreFactor(Game game) {
        return diffScoreFactor * (game.getaScore() - game.getbScore());
    }
}
