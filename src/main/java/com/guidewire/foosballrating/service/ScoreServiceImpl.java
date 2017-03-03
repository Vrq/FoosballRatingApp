package com.guidewire.foosballrating.service;

import com.guidewire.foosballrating.domain.Score;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Date;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Override
    public List<Score> getAllScoreForPlayer(String playerName) {
        throw new NotImplementedException();
    }

    @Override
    public Score getLatestScoreForPlayer(String playerName) {
        throw new NotImplementedException();
    }

    @Override
    public List<Score> getScoreForPlayerInTime(String playerName, Date startDate, Date endDate) {
        throw new NotImplementedException();
    }
}
