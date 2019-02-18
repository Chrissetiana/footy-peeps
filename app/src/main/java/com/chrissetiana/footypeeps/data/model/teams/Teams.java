package com.chrissetiana.footypeeps.data.model.teams;

import com.chrissetiana.footypeeps.data.model.competitions.Competition;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Teams {
    // for competition/teams (list)
    // https://api.football-data.org/v2/competitions/{id}/teams

    @SerializedName("count")
    @Expose
    private Integer countTeams;

    @SerializedName("competition")
    @Expose
    private Competition teamCompetition;

    @SerializedName("teams")
    @Expose
    private List<Team> teamList;

    public Integer getCountTeams() {
        return countTeams;
    }

    public Competition getTeamCompetition() {
        return teamCompetition;
    }

    public List<Team> getTeamList() {
        return teamList;
    }
}
