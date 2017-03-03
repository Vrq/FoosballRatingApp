package com.guidewire.foosballrating.persistence;

import com.guidewire.foosballrating.domain.Player;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
public interface PlayerMapper {

    String insert = "INSERT INTO players (username, gamesWon, gamesLost, setsWon, setsLost, points, winCount, lossCount) " +
            "VALUES (#{username}, #{gamesWon}, #{gamesLost}, #{setsWon}, #{setsLost}, #{points}, #{winCount}, #{lossCount})";
    String update = "UPDATE players SET gamesWon = #{gamesWon}, gamesLost = #{gamesLost}, setsWon = #{setsWon}, setsLost = #{setsLost}," +
            " points = #{points}, winCount = #{winCount}, lossCount=#{lossCount} WHERE username = #{username}";

    @Select("SELECT * from players ORDER BY points DESC, gamesWon DESC, setsWon DESC, username ASC")
    List<Player> getAllPlayers();

    @Select("SELECT * FROM players ORDER BY points desc limit 10")
    List<Player> getBest10();

    @Insert(insert)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertPlayer(Player player);

    @Select("Select * from players where username=#{username}")
    Player getByUsername(String username);

    @Update(update)
    int updatePlayer(Player player);

    @Select("SELECT * FROM players ORDER BY winCount DESC")
    List<Player> getByWinCount();

    @Select("SELECT * FROM players ORDER BY lossCount DESC")
    List<Player> getByLossCount();

}
