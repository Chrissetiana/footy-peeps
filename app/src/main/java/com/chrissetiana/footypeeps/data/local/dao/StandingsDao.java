package com.chrissetiana.footypeeps.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.chrissetiana.footypeeps.data.model.standings.StandingsEntity;

import java.util.List;

@Dao
public interface StandingsDao {

    @Query("SELECT * FROM standings WHERE comp_id = :id")
    StandingsEntity queryStanding(int id);

    @Insert
    void insertStandings(List<StandingsEntity> entities);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertStanding(StandingsEntity entity);

    @Update
    void updateStandings(List<StandingsEntity> entities);

    @Update
    void updateStanding(StandingsEntity entity);

    @Delete
    void deleteStandings(List<StandingsEntity> entities);

    @Delete
    void deleteStanding(StandingsEntity entity);

    @Query("DELETE FROM standings")
    void deleteAllStandings();
}
