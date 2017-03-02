package com.guidewire.foosballrating.persistence;

import com.guidewire.foosballrating.domain.Game;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GameMapper {

    @Select("SELECT * FROM games")
    public List<Game> getAllGames();

    public int insertGame(Game game);

    public int updateGame(Game game);
}
