package com.guidewire.foosballrating.persistence;

import com.guidewire.foosballrating.domain.Score;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface ScoreMapper {

    String selectBetweenDates = "SELECT * FROM scores WHERE username=#{username} AND creationTime BETWEEN #{from} AND #{to}";
    String insert = "INSERT INTO scores (username, rank, points, creationTime) VALUES (#{username}, #{rank}, #{points}, #{creationTime})";

    @Select("SELECT * FROM scores WHERE username=#{username} ORDER BY creationTime DESC LIMIT 1")
    Score getLatestScoreForPlayer(@Param("username") String username);

    @Select("SELECT * FROM scores WHERE username=#{username}")
    List<Score> getAllScores(@Param("username") String username);

    @Select(selectBetweenDates)
    List<Score> getScoresBetweenDates(@Param("username") String username, @Param("from") Date from, @Param("to") Date to);

    @Insert(insert)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertScore(Score score);
}
