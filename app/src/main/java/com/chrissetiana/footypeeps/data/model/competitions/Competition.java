package com.chrissetiana.footypeeps.data.model.competitions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Competition {

    @SerializedName("id")
    @Expose
    private int competitionId;

    @SerializedName("name")
    @Expose
    private String competitionName;

    public int getCompetitionId() {
        return competitionId;
    }

    public String getCompetitionName() {
        return competitionName;
    }
}
