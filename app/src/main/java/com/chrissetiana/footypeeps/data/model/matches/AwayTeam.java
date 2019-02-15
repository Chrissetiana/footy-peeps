package com.chrissetiana.footypeeps.data.model.matches;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AwayTeam {

    @SerializedName("name")
    @Expose
    private String awayTeamName;

    public String getAwayTeamName() {
        return awayTeamName;
    }
}
