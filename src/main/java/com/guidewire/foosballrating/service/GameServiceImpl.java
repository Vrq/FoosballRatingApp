package com.guidewire.foosballrating.service;


import com.guidewire.foosballrating.domain.Game;
import com.guidewire.foosballrating.persistence.GameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameMapper gameMapper;

    @Override
    public List<Game> getAllGames() {
        Optional<List<Game>> result = Optional.of(gameMapper.getAllGames());
        return result.orElse(new ArrayList<>());
    }

    @Override
    public int insertGame(Game game) {
        throw new NotImplementedException();
    }

    @Override
    public int updateGame(Game game) {
        throw new NotImplementedException();
    }
}
