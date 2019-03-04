package com.chrissetiana.footypeeps.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.chrissetiana.footypeeps.data.model.teams.PlayersEntity;

import java.util.List;

@Dao
public interface PlayersDao {

    @Query("SELECT COUNT(id) FROM players")
    int countAllPlayers();

    @Query("SELECT * FROM players WHERE team_id = :id")
    PlayersEntity queryPlayer(int id);

    @Insert
    void insertPlayers(List<PlayersEntity> entities);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPlayer(PlayersEntity entity);

    @Update
    void updatePlayers(List<PlayersEntity> entities);

    @Update
    void updatePlayer(PlayersEntity entity);

    @Delete
    void deletePlayers(List<PlayersEntity> entities);

    @Delete
    void deletePlayer(PlayersEntity entity);

    @Query("DELETE FROM players")
    void deleteAllPlayers();
}
