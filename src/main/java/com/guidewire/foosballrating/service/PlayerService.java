package com.guidewire.foosballrating.service;


import com.guidewire.foosballrating.domain.Game;
import com.guidewire.foosballrating.domain.Player;

import java.util.List;

public interface PlayerService {

    public Player getPlayer(int id);

    public List<Player> getAllPlayers();

    public int insertPlayer(Game game);

    public int updatePlayer(Game game);
}
