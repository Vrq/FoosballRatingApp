package com.guidewire.foosballrating.persistence;

import com.guidewire.foosballrating.domain.Game;

import java.util.List;

public interface GameMapper {


    public List<Game> getAllGames();

    public int insertGame(Game game);

    public int updateGame(Game game);
}
