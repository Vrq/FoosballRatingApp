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

        if (isTeamAWinner(game)) {
            if (isTeamAPlayer(player, game)) {
                return increasePoints(player, game);
            } else {
                return decreasePoints(player, game);
            }
        } else if (isDraw(game)) {
            return increasePointsForDraw(player, game);
        } else {//team B winner
            if (isTeamAPlayer(player, game)) {
                return decreasePoints(player, game);
            } else {
                return increasePoints(player, game);
            }
        }
    }

    private int increasePointsForDraw(Player player, Game game) {
        return (int) Math.round(player.getPoints() + (calculateScoreFactor(game) * multiplierFactor) / 3);
    }

    private int decreasePoints(Player player, Game game) {

        int result = (int) Math.round(player.getPoints() - (calculateScoreFactor(game) * multiplierFactor) / 2);
        return result < 0 ? 0 : result;
    }

    private int increasePoints(Player player, Game game) {
        return (int) Math.round(player.getPoints() + (calculateScoreFactor(game) * multiplierFactor));
    }

    private double calculateScoreFactor(Game game) {
        return diffScoreFactor * (game.getaScore() - game.getbScore());
    }

    private boolean isTeamAPlayer(Player player, Game game) {
        return player.getUsername().equals(game.getaPlayer1()) ||
                player.getUsername().equals(game.getaPlayer2());
    }

    private boolean isTeamAWinner(Game game) {
        return game.getaScore() > game.getbScore();
    }

    private boolean isDraw(Game game) {
        return game.getaScore() == game.getbScore();
    }
}
