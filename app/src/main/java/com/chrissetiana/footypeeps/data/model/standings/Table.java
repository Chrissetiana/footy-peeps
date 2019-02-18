package com.chrissetiana.footypeeps.data.model.standings;

import com.chrissetiana.footypeeps.data.model.teams.Team;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Table {

    @SerializedName("position")
    @Expose
    private Integer tablePosition;

    @SerializedName("team")
    @Expose
    private Team tableTeam;

    @SerializedName("playedGames")
    @Expose
    private Integer tablePlayed;

    @SerializedName("points")
    @Expose
    private Integer tablePoints;

    @SerializedName("goalDifference")
    @Expose
    private Integer tableDifference;

    public Integer getTablePosition() {
        return tablePosition;
    }

    public Team getTableTeam() {
        return tableTeam;
    }

    public Integer getTablePlayed() {
        return tablePlayed;
    }

    public Integer getTablePoints() {
        return tablePoints;
    }

    public Integer getTableDifference() {
        return tableDifference;
    }
}
