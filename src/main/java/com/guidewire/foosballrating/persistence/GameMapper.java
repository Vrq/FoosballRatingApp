package com.guidewire.foosballrating.persistence;

import com.guidewire.foosballrating.domain.Game;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GameMapper {

    String insert = "INSERT INTO games (aPlayer1, aPlayer2, bPlayer1, bPlayer2, aScore, bScore, dateOfGame) VALUES (#{aPlayer1}, #{aPlayer2}, #{bPlayer1}, #{bPlayer2}, #{aScore}, #{bScore}, #{dateOfGame})";
    String update = "UPDATE STUDENT SET aPlayer1 = #{aPlayer1}, aPlayer2 = #{aPlayer2}, bPlayer1 = #{bPlayer1}, bPlayer2 = #{bPlayer2}, aScore = #{aScore}, bScore = #{bScore}, dateOfGame = #{dateOfGame} WHERE ID = #{id}";

    @Select("SELECT * FROM games")
    List<Game> getAllGames();

    @Insert(insert)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertGame(Game game);

    @Update(update)
    int updateGame(Game game);
}
