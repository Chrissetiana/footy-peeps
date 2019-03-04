package com.chrissetiana.footypeeps.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.chrissetiana.footypeeps.data.model.teams.TeamsEntity;

import java.util.List;

@Dao
public interface TeamsDao {

    @Query("SELECT COUNT(id) FROM teams")
    int countAllTeams();

    @Query("SELECT * FROM teams")
    List<TeamsEntity> queryAllTeams();

    @Query("SELECT * FROM teams WHERE comp_id = :id")
    TeamsEntity queryTeam(int id);

    @Insert
    void insertTeams(List<TeamsEntity> entities);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTeam(TeamsEntity entity);

    @Update
    void updateTeams(List<TeamsEntity> entities);

    @Update
    void updateTeam(TeamsEntity entity);

    @Delete
    void deleteTeams(List<TeamsEntity> entities);

    @Delete
    void deleteTeam(TeamsEntity entity);

    @Query("DELETE FROM teams")
    void deleteAllTeams();
}
