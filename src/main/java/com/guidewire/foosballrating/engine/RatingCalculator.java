package com.guidewire.foosballrating.engine;

import com.guidewire.foosballrating.domain.Player;

public interface RatingCalculator {

    public int startingRating();

    public int calcuatePlayerRating(Player player);

}
