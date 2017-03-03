package com.guidewire.foosballrating.service;


import com.guidewire.foosballrating.domain.Player;

import java.util.List;

public interface PlayerService {

    public Player getPlayer(int id);

    public Player getPlayer(String username);

    public List<Player> getAllPlayers();

    public int insertPlayer(Player player);

    public int updatePlayer(Player player);

    boolean isUsernameAvailable(String username);

    int getPlayerRank(String username);

}
