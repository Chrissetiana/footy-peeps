package com.chrissetiana.footypeeps.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Teams {
    // for competition/teams (list)
    // https://api.football-data.org/v2/competitions/{id}/teams

    @SerializedName("count")
    @Expose
    public Integer countTeams;

    @SerializedName("competition")
    @Expose
    public Competition teamCompetition;

    @SerializedName("teams")
    @Expose
    public List<Team> teamList;

    public Teams(Integer countTeams, Competition teamCompetition, List<Team> teamList) {
        this.countTeams = countTeams;
        this.teamCompetition = teamCompetition;
        this.teamList = teamList;
    }

    public Integer getCountTeams() {
        return countTeams;
    }

    public void setCountTeams(Integer countTeams) {
        this.countTeams = countTeams;
    }

    public Competition getTeamCompetition() {
        return teamCompetition;
    }

    public void setTeamCompetition(Competition teamCompetition) {
        this.teamCompetition = teamCompetition;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }
}
