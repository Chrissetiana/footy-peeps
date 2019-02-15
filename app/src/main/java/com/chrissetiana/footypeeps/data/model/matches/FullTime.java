package com.chrissetiana.footypeeps.data.model.matches;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FullTime {

    @SerializedName("homeTeam")
    @Expose
    private Integer homeTeamWin;

    @SerializedName("awayTeam")
    @Expose
    private Integer awayTeamWin;

    public Integer getHomeTeamWin() {
        return homeTeamWin;
    }

    public Integer getAwayTeamWin() {
        return awayTeamWin;
    }
}
