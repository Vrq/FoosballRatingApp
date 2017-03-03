package com.guidewire.foosballrating.engine;

import com.guidewire.foosballrating.domain.Game;
import com.guidewire.foosballrating.domain.Player;

public interface RatingCalculator {

    public int startingRating();

    public int calcuatePlayerPoints(Player player, Game game);

}
