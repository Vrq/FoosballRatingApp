package com.guidewire.foosballrating.service;


import com.guidewire.foosballrating.domain.Score;

import java.util.Date;
import java.util.List;

public interface ScoreService {
    public List<Score> getAllScoreForPlayer(String playerName);

    public Score getLatestScoreForPlayer(String playerName);

    public List<Score> getScoreForPlayerInTime(String playerName, Date startDate, Date endDate);

}
