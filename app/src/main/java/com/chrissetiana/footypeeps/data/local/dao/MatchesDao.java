package com.chrissetiana.footypeeps.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.chrissetiana.footypeeps.data.local.entity.MatchesEntity;

import java.util.List;

@Dao
public interface MatchesDao {

    @Query("SELECT COUNT(id) FROM matches")
    int countAllMatches();

    @Query("SELECT * FROM matches WHERE comp_id = :id")
    MatchesEntity queryMatchFromCompetition(int id);

    @Query("SELECT * FROM matches WHERE date = :today")
    MatchesEntity queryMatch(String today);

    @Insert
    void insertMatches(List<MatchesEntity> entities);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMatch(MatchesEntity entity);

    @Update
    void updateMatches(List<MatchesEntity> entities);

    @Update
    void updateMatch(MatchesEntity entity);

    @Delete
    void deleteMatches(List<MatchesEntity> entities);

    @Delete
    void deleteMatch(MatchesEntity entity);

    @Query("DELETE FROM matches")
    void deleteAllMatches();
}
