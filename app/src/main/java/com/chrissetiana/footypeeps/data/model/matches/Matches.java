package com.chrissetiana.footypeeps.data.model.matches;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Matches {
    // for today's matchList (matches) list
    // https://api.football-data.org/v2/matchList

    @SerializedName("countMatches")
    @Expose
    public Integer countMatches;

    @SerializedName("matchList")
    @Expose
    public List<Match> matchList;

    public Matches(Integer countMatches, List<Match> matchList) {
        this.countMatches = countMatches;
        this.matchList = matchList;
    }

    public Integer getCountMatches() {
        return countMatches;
    }

    public void setCountMatches(Integer countMatches) {
        this.countMatches = countMatches;
    }

    public List<Match> getMatchList() {
        return matchList;
    }

    public void setMatchList(List<Match> matchList) {
        this.matchList = matchList;
    }
}
