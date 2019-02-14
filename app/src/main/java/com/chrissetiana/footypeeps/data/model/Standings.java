package com.chrissetiana.footypeeps.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Standings {
    // for competition/standings
    // https://api.football-data.org/v2/competitions/{id}/standings

    @SerializedName("standings")
    @Expose
    public List<Standing> standingList = null;

    public class Standing {
        @SerializedName("table")
        @Expose
        public List<Table> tableList = null;
    }

    public class Table {
        @SerializedName("position")
        @Expose
        public Integer standingPosition;

        @SerializedName("team")
        @Expose
        public Team standingTeam;

        @SerializedName("playedGames")
        @Expose
        public Integer standingPlayed;

        @SerializedName("points")
        @Expose
        public Integer standingPoints;

        @SerializedName("goalDifference")
        @Expose
        public Integer standingDifference;
    }

    public class Team {
        @SerializedName("name")
        @Expose
        public String standingTeamName;
    }
}
