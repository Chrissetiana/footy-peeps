package com.chrissetiana.footypeeps.data.model.matches;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeTeam {

    @SerializedName("name")
    @Expose
    private String homeTeamName;

    public String getHomeTeamName() {
        return homeTeamName;
    }
}


