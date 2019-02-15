package com.chrissetiana.footypeeps.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class HomeTeam {
    @SerializedName("name")
    @Expose
    public String homeTeamName;

    public HomeTeam(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }
}


