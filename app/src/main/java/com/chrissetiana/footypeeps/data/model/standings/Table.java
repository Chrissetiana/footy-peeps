package com.chrissetiana.footypeeps.data.model.standings;

import com.chrissetiana.footypeeps.data.model.teams.Team;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Table {
    @SerializedName("position")
    @Expose
    public Integer tablePosition;

    @SerializedName("team")
    @Expose
    public Team tableTeam;

    @SerializedName("playedGames")
    @Expose
    public Integer tablePlayed;

    @SerializedName("points")
    @Expose
    public Integer tablePoints;

    @SerializedName("goalDifference")
    @Expose
    public Integer tableDifference;

    public Table(Integer tablePosition, Team tableTeam, Integer tablePlayed, Integer tablePoints, Integer tableDifference) {
        this.tablePosition = tablePosition;
        this.tableTeam = tableTeam;
        this.tablePlayed = tablePlayed;
        this.tablePoints = tablePoints;
        this.tableDifference = tableDifference;
    }

    public Integer getTablePosition() {
        return tablePosition;
    }

    public void setTablePosition(Integer tablePosition) {
        this.tablePosition = tablePosition;
    }

    public Team getTableTeam() {
        return tableTeam;
    }

    public void setTableTeam(Team tableTeam) {
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
