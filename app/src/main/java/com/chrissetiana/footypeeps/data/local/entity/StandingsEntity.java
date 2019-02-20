package com.chrissetiana.footypeeps.data.local.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "standings",
        indices = {
                @Index(value = "comp_id")},
        foreignKeys = @ForeignKey(entity = CompetitionsEntity.class,
                parentColumns = "id", childColumns = "comp_id",
                onDelete = ForeignKey.CASCADE))
public class StandingsEntity {

    @ColumnInfo(name = "no")
    @PrimaryKey(autoGenerate = true)
    private int baseId;

    @ColumnInfo(name = "comp_id")
    private Integer tableCompetitionId;

    @ColumnInfo(name = "position")
    private Integer tablePosition;

    @ColumnInfo(name = "name", index = true)
    private String tableTeam;

    @ColumnInfo(name = "played")
    private Integer tablePlayed;

    @ColumnInfo(name = "points")
    private Integer tablePoints;

    @ColumnInfo(name = "difference")
    private Integer tableDifference;

    public int getBaseId() {
        return baseId;
    }

    public void setBaseId(int baseId) {
        this.baseId = baseId;
    }

    public Integer getTableCompetitionId() {
        return tableCompetitionId;
    }

    public void setTableCompetitionId(Integer tableCompetitionId) {
        this.tableCompetitionId = tableCompetitionId;
    }

    public Integer getTablePosition() {
        return tablePosition;
    }

    public void setTablePosition(Integer tablePosition) {
        this.tablePosition = tablePosition;
    }

    public String getTableTeam() {
        return tableTeam;
    }

    public void setTableTeam(String tableTeam) {
        this.tableTeam = tableTeam;
    }

    public Integer getTablePlayed() {
        return tablePlayed;
    }

    public void setTablePlayed(Integer tablePlayed) {
        this.tablePlayed = tablePlayed;
    }

    public Integer getTablePoints() {
        return tablePoints;
    }

    public void setTablePoints(Integer tablePoints) {
        this.tablePoints = tablePoints;
    }

    public Integer getTableDifference() {
        return tableDifference;
    }

    public void setTableDifference(Integer tableDifference) {
        this.tableDifference = tableDifference;
    }
}
