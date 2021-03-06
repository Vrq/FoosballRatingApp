package com.guidewire.foosballrating.service;

import com.guidewire.foosballrating.domain.Score;
import com.guidewire.foosballrating.persistence.ScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    ScoreMapper scoreMapper;

    @Override
    public int insertScore(Score score) {
        return scoreMapper.insertScore(score);
    }

    @Override
    public List<Score> getAllScoreForPlayer(String playerName) {
        return scoreMapper.getAllScores(playerName);
    }

    @Override
    public Score getLatestScoreForPlayer(String playerName) {
        return scoreMapper.getLatestScoreForPlayer(playerName);
    }

    @Override
    public Score getPreviousScoreForPlayer(String playerName) {
        return scoreMapper.getPreviousScore(playerName);
    }

    @Override
    public List<Score> getScoreForPlayerInTime(String playerName, Date startDate, Date endDate) {
        return scoreMapper.getScoresBetweenDates(playerName, startDate, endDate);
    }
}
