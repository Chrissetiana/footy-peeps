package com.chrissetiana.footypeeps.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Matches {
    // for competition/matches
    // https://api.football-data.org/v2/competitions/{id}/matches

    @SerializedName("matches")
    @Expose
    public List<Match> matchList = null;

    public class Match {
        @SerializedName("id")
        @Expose
        public Integer matchId;

        @SerializedName("season")
        @Expose
        public Season matchSeason;

        @SerializedName("matchday")
        @Expose
        public Integer matchDay;

        @SerializedName("status")
        @Expose
        public String matchStatus;

        @SerializedName("homeTeam")
        @Expose
        public HomeTeam matchHomeTeam;

        @SerializedName("awayTeam")
        @Expose
        public AwayTeam matchAwayTeam;

        @SerializedName("score")
        @Expose
        public Score matchScore;
    }

    public class Season {
        @SerializedName("startDate")
        @Expose
        public String matchSeasonStart;

        @SerializedName("endDate")
        @Expose
        public String matchSeasonEnd;
    }

    public class HomeTeam {
        @SerializedName("name")
        @Expose
        public String matchHomeName;
    }

    public class AwayTeam {
        @SerializedName("name")
        @Expose
        public String matchAwayName;
    }

    public class Score {
        @SerializedName("fullTime")
        @Expose
        public FullTime matchFullTime;
    }

    public class FullTime {
        @SerializedName("homeTeam")
        @Expose
        public Integer matchHomeWin;

        @SerializedName("awayTeam")
        @Expose
        public Integer matchAwayWin;
    }
}
