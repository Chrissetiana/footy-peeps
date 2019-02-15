package com.chrissetiana.footypeeps.data.model.matches;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Matches {
    // for today's matchList (matches) list
    // https://api.football-data.org/v2/matchList

    @SerializedName("count")
    @Expose
    private Integer countMatches;

    @SerializedName("matches")
    @Expose
    private List<Match> matchList;

    public Integer getCountMatches() {
        return countMatches;
    }

    public List<Match> getMatchList() {
        return matchList;
    }
}
