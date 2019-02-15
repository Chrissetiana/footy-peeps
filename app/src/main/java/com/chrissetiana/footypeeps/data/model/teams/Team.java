package com.chrissetiana.footypeeps.data.model.teams;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Team {
    // for competition/teams (teams)
    // https://api.football-data.org/v2/teams/{id}

    @SerializedName("id")
    @Expose
    public Integer teamId;

    @SerializedName("name")
    @Expose
    public String teamName;

    @SerializedName("crestUrl")
    @Expose
    public String teamLogo;

    @SerializedName("squad")
    @Expose
    public List<Squad> squadList;

    public Team(Integer teamId, String teamName, String teamLogo, List<Squad> squadList) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamLogo = teamLogo;
        this.squadList = squadList;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamLogo() {
        return teamLogo;
    }

    public void setTeamLogo(String teamLogo) {
        this.teamLogo = teamLogo;
    }

    public List<Squad> getSquadList() {
        return squadList;
    }

    public void setSquadList(List<Squad> squad) {
        this.squadList = squad;
    }
}
