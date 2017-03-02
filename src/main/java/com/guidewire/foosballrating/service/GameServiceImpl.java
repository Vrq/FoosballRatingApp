package com.guidewire.foosballrating.service;


import com.guidewire.foosballrating.domain.Game;
import com.guidewire.foosballrating.persistence.GameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameMapper gameMapper;

    @Autowired
    private RatingService ratingService;

    @Override
    public List<Game> getAllGames() {
        Optional<List<Game>> result = Optional.of(gameMapper.getAllGames());
        return result.orElse(new ArrayList<>());
    }

    @Override
    public void insertGame(Game game) {
        game.setDateOfGame(new Timestamp(new Date().getTime()));
        gameMapper.insertGame(game);
        ratingService.updateRatings(game);
    }

    @Override
    public int updateGame(Game game) {
        return gameMapper.updateGame(game);
    }
}
