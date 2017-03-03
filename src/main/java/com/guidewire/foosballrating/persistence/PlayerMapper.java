package com.guidewire.foosballrating.persistence;

import com.guidewire.foosballrating.domain.Player;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

//@Mapper
public interface PlayerMapper {

    String insert = "INSERT INTO players (username, gamesWon, gamesLost, setsWon, setsLost, points) VALUES (#{username}, #{gamesWon}, #{gamesLost}, #{setsWon}, #{setsLost}, #{points})";
    String update = "UPDATE players SET gamesWon = #{gamesWon}, gamesLost = #{gamesLost}, setsWon = #{setsWon}, setsLost = #{setsLost}, points = #{rank} WHERE username = #{username}";

    @Select("SELECT * from players ORDER BY points desc")
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


}
