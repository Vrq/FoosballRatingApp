package com.guidewire.foosballrating.persistence;

import com.guidewire.foosballrating.domain.Player;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PlayerMapper {

    String insert = "INSERT INTO players (username, gamesWon, gamesLost, setsWon, setsLost, points) VALUES (#{username}, 0, 0, 0, 0, 100)";
    String update = "UPDATE players SET gamesWon = #{gamesWon}, gamesLost = #{gamesLost}, setsWon = #{setsWon}, setsLost = #{setsLost}, points = #{rank} WHERE username = #{username}";

    @Select("SELECT * from players ORDER BY rank")
    List<Player> getAllPlayers();

    @Select("SELECT * FROM players ORDER BY rank limit 10")
    List<Player> getBest10();

    @Insert(insert)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertPlayer(@Param("username")String username);

    @Select("Select * from players where username=#{username}")
    Player getByUsername(String username);

    @Update(update)
    int updatePlayer(Player player);


}
