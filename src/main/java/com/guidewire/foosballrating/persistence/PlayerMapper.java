package com.guidewire.foosballrating.persistence;

import com.guidewire.foosballrating.domain.Player;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
public interface PlayerMapper {

    String insert = "INSERT INTO players (username, gamesWon, gamesLost, setsWon, setsLost, points) VALUES (#{username}, 0, 0, 0, 0, #{points})";
    String update = "UPDATE players SET gamesWon = #{gamesWon}, gamesLost = #{gamesLost}, setsWon = #{setsWon}, setsLost = #{setsLost}, points = #{points} WHERE username = #{username}";
    String selectRank = "SELECT z.rank FROM (SELECT username, points, gamesWon, setsWon, rownum() as rank FROM players ORDER BY points DESC , gamesWon DESC, setsWon DESC) as z WHERE username=#{username}";

    @Select("SELECT * from players ORDER BY points DESC , gamesWon DESC, setsWon DESC")
    List<Player> getAllPlayers();

    @Select("SELECT * FROM players ORDER BY points desc limit 10")
    List<Player> getBest10();

    @Insert(insert)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertPlayer(@Param("username") String username, @Param("points") int points);

    @Select("Select * from players where username=#{username}")
    Player getByUsername(String username);

    @Update(update)
    int updatePlayer(Player player);

    @Select(selectRank)
    int getPlayerRank(@Param("username")String username);


}
