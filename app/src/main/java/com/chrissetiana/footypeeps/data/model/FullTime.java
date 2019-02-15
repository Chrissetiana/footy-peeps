package com.chrissetiana.footypeeps.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class FullTime {
    @SerializedName("homeTeam")
    @Expose
    public Integer homeTeamWin;

    @SerializedName("awayTeam")
    @Expose
    public Integer awayTeamWin;

    public FullTime(Integer homeTeamWin, Integer awayTeamWin) {
        this.homeTeamWin = homeTeamWin;
        this.awayTeamWin = awayTeamWin;
    }

    public Integer getHomeTeamWin() {
        return homeTeamWin;
    }

    public void setHomeTeamWin(Integer homeTeamWin) {
        this.homeTeamWin = homeTeamWin;
    }

    public Integer getAwayTeamWin() {
        return awayTeamWin;
    }

    public void setAwayTeamWin(Integer awayTeamWin) {
        this.awayTeamWin = awayTeamWin;
    }
}
