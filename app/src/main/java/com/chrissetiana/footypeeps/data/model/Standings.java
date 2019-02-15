package com.chrissetiana.footypeeps.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Standings {
    // for competition/standings
    // https://api.football-data.org/v2/competitions/{id}/standings

    @SerializedName("competition")
    @Expose
    public Competition standingCompetition;

    @SerializedName("standingList")
    @Expose
    public List<Standing> standingList;

    public Standings(Competition standingCompetition, List<Standing> standingList) {
        this.standingCompetition = standingCompetition;
        this.standingList = standingList;
    }

    public Competition getStandingCompetition() {
        return standingCompetition;
    }

    public void setStandingCompetition(Competition standingCompetition) {
        this.standingCompetition = standingCompetition;
    }

    public List<Standing> getStandingList() {
        return standingList;
    }

    public void setStandingList(List<Standing> standingList) {
        this.standingList = standingList;
    }
}
