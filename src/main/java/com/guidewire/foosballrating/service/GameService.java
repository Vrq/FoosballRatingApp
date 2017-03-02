package com.guidewire.foosballrating.service;


import com.guidewire.foosballrating.domain.Game;

import java.util.List;

public interface GameService {

    public List<Game> getAllGames();

    public int insertGame(Game game);

    public int updateGame(Game game);
}
