package com.guidewire.foosballrating.service;


import com.guidewire.foosballrating.domain.Player;
import com.guidewire.foosballrating.persistence.PlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerMapper playerMapper;

    @Override
    public Player getPlayer(int id) {
        throw new NotImplementedException();
    }

    @Override
    public Player getPlayer(String username) {
        return playerMapper.getByUsername(username);
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerMapper.getAllPlayers();
    }

    @Override
    public int insertPlayer(Player player) {
        //TODO change implementation
        return playerMapper.insertPlayer(player);
    }

    @Override
    public int updatePlayer(Player player) {
        return playerMapper.updatePlayer(player);
    }

    @Override
    public boolean isUsernameAvailable(String username) {
        return playerMapper.getByUsername(username) != null;
    }

}
