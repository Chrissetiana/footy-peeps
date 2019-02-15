package com.chrissetiana.footypeeps.data.model.competitions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Competitions {
    // for competitions list
    // https://api.football-data.org/v2/competitions

    @SerializedName("count")
    @Expose
    private Integer countCompetitions;

    @SerializedName("competitionList")
    @Expose
    private List<Competition> competitionList;

    public Competitions(Integer countCompetitions, List<Competition> competitionList) {
        this.countCompetitions = countCompetitions;
        this.competitionList = competitionList;
    }

    public Integer getCountCompetitions() {
        return countCompetitions;
    }

    public void setCountCompetitions(Integer countCompetitions) {
        this.countCompetitions = countCompetitions;
    }

    public List<Competition> getCompetitionList() {
        return competitionList;
    }

    public void setCompetitionList(List<Competition> competitionList) {
        this.competitionList = competitionList;
    }
}
