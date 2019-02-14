package com.chrissetiana.footypeeps.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Competitions {
    // for competitions list
    // https://api.football-data.org/v2/competitions

    @SerializedName("competitions")
    @Expose
    public List<Competition> competitionList = null;

    public class Competition {
        @SerializedName("id")
        @Expose
        public Integer competitionId;

        @SerializedName("name")
        @Expose
        public String competitionName;

        @SerializedName("currentSeason")
        @Expose
        public CurrentSeason competitionSeason;
    }

    public class CurrentSeason {
        @SerializedName("startDate")
        @Expose
        public String competitionSeasonStart;

        @SerializedName("endDate")
        @Expose
        public String competitionSeasonEnd;
    }
}
