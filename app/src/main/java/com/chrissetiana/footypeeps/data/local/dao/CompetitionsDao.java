package com.chrissetiana.footypeeps.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.chrissetiana.footypeeps.data.model.competitions.CompetitionsEntity;

import java.util.List;

@Dao
public interface CompetitionsDao {

    @Query("SELECT COUNT(id) FROM competitions")
    int countAllCompetitions();

    @Query("SELECT * FROM competitions")
    List<CompetitionsEntity> queryAllCompetitions();

    @Query("SELECT * FROM competitions WHERE id = :id")
    CompetitionsEntity queryCompetition(int id);

    @Insert
    void insertCompetitions(List<CompetitionsEntity> entities);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCompetition(CompetitionsEntity entity);

    @Update
    void updateCompetitions(List<CompetitionsEntity> entities);

    @Update
    void updateCompetition(CompetitionsEntity entity);

    @Delete
    void deleteCompetitions(List<CompetitionsEntity> entities);

    @Delete
    void deleteCompetition(CompetitionsEntity entity);

    @Query("DELETE FROM competitions")
    void deleteAllCompetitions();
}
