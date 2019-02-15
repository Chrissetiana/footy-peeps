package com.chrissetiana.footypeeps.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class AwayTeam {
    @SerializedName("name")
    @Expose
    public String awayTeamName;

    public AwayTeam(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }
}
