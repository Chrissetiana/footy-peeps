package com.chrissetiana.footypeeps.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Teams {
    // for competition/teams (list)
    // https://api.football-data.org/v2/competitions/{id}/teams

    @SerializedName("teams")
    @Expose
    public List<Team> teamList = null;

    public class Team {
        @SerializedName("id")
        @Expose
        public Integer teamId;

        @SerializedName("name")
        @Expose
        public String teamName;
    }
}
