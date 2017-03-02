package com.guidewire.foosballrating.service;


import com.guidewire.foosballrating.domain.Player;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Override
    public Player getPlayer(int id) {
        throw new NotImplementedException();
    }

    @Override
    public Player getPlayer(String username) {
        throw new NotImplementedException();
    }

    @Override
    public List<Player> getAllPlayers() {
        throw new NotImplementedException();
    }

    @Override
    public int insertPlayer(Player player) {
        throw new NotImplementedException();
    }

    @Override
    public int updatePlayer(Player player) {
        throw new NotImplementedException();
    }
}
