package com.chrissetiana.footypeeps.data.local.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "matches",
        indices = {
                @Index(value = "comp_id"),
                @Index(value = "id", unique = true)},
        foreignKeys = @ForeignKey(entity = CompetitionsEntity.class,
                parentColumns = "id", childColumns = "comp_id",
                onDelete = ForeignKey.CASCADE))
public class MatchesEntity {

    @ColumnInfo(name = "no")
    @PrimaryKey(autoGenerate = true)
    private int baseId;

    @ColumnInfo(name = "comp_id")
    private Integer matchCompetitionId;

    @ColumnInfo(name = "id")
    private Integer matchId;

    @ColumnInfo(name = "date")
    private String matchDate;

    @ColumnInfo(name = "status")
    private String matchStatus;

    @ColumnInfo(name = "matchday")
    private Integer matchDay;

    @ColumnInfo(name = "home_team", index = true)
    private String matchHomeTeam;

    @ColumnInfo(name = "home_win")
    private Integer matchHomeWin;

    @ColumnInfo(name = "away_team", index = true)
    private String matchAwayTeam;

    @ColumnInfo(name = "away_win")
    private Integer matchAwayWin;

    public int getBaseId() {
        return baseId;
    }

    public void setBaseId(int baseId) {
        this.baseId = baseId;
    }

    public Integer getMatchCompetitionId() {
        return matchCompetitionId;
    }

    public void setMatchCompetitionId(Integer matchCompetitionId) {
        this.matchCompetitionId = matchCompetitionId;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public String getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(String matchStatus) {
        this.matchStatus = matchStatus;
    }

    public Integer getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(Integer matchDay) {
        this.matchDay = matchDay;
    }

    public String getMatchHomeTeam() {
        return matchHomeTeam;
    }

    public void setMatchHomeTeam(String matchHomeTeam) {
        this.matchHomeTeam = matchHomeTeam;
    }

    public Integer getMatchHomeWin() {
        return matchHomeWin;
    }

    public void setMatchHomeWin(Integer matchHomeWin) {
        this.matchHomeWin = matchHomeWin;
    }

    public String getMatchAwayTeam() {
        return matchAwayTeam;
    }

    public void setMatchAwayTeam(String matchAwayTeam) {
        this.matchAwayTeam = matchAwayTeam;
    }

    public Integer getMatchAwayWin() {
        return matchAwayWin;
    }

    public void setMatchAwayWin(Integer matchAwayWin) {
        this.matchAwayWin = matchAwayWin;
    }
}
