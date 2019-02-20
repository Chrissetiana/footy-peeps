package com.chrissetiana.footypeeps.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.chrissetiana.footypeeps.data.local.dao.CompetitionsDao;
import com.chrissetiana.footypeeps.data.local.dao.MatchesDao;
import com.chrissetiana.footypeeps.data.local.dao.PlayersDao;
import com.chrissetiana.footypeeps.data.local.dao.StandingsDao;
import com.chrissetiana.footypeeps.data.local.dao.TeamsDao;
import com.chrissetiana.footypeeps.data.local.entity.CompetitionsEntity;
import com.chrissetiana.footypeeps.data.local.entity.MatchesEntity;
import com.chrissetiana.footypeeps.data.local.entity.PlayersEntity;
import com.chrissetiana.footypeeps.data.local.entity.StandingsEntity;
import com.chrissetiana.footypeeps.data.local.entity.TeamsEntity;
import com.chrissetiana.footypeeps.util.Config;

@Database(entities = {CompetitionsEntity.class, MatchesEntity.class, PlayersEntity.class, StandingsEntity.class, TeamsEntity.class},
        version = 1) // bump version number if your schema changes
public abstract class DbClass extends RoomDatabase {

    // Database name to be used
    static final String DB_NAME = Config.DATABASE_NAME;

    // Declare your data access objects as abstract
    public abstract CompetitionsDao competitionDao();

    public abstract MatchesDao matchDao();

    public abstract PlayersDao squadDao();

    public abstract StandingsDao standingDao();

    public abstract TeamsDao teamDao();
}
