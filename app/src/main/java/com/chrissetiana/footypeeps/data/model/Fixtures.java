package com.chrissetiana.footypeeps.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Fixtures {
    // for today's matches (fixtures) list
    // https://api.football-data.org/v2/matches

    @SerializedName("matches")
    @Expose
    public List<Match> fixtureList = null;

    public class Match {
        @SerializedName("id")
        @Expose
        public Integer fixtureId;

        @SerializedName("season")
        @Expose
        public Season fixtureSeason;

        @SerializedName("matchday")
        @Expose
        public Integer fixtureMatchday;

        @SerializedName("status")
        @Expose
        public String fixtureStatus;

        @SerializedName("homeTeam")
        @Expose
        public HomeTeam fixtureHomeTeam;

        @SerializedName("awayTeam")
        @Expose
        public AwayTeam fixtureAwayTeam;

        @SerializedName("score")
        @Expose
        public Score fixtureScore;
    }

    public class Season {
        @SerializedName("startDate")
        @Expose
        public String fixtureSeasonStart;

        @SerializedName("endDate")
        @Expose
        public String fixtureSeasonEnd;
    }

    public class HomeTeam {
        @SerializedName("name")
        @Expose
        public String fixtureHomeName;
    }

    public class AwayTeam {
        @SerializedName("name")
        @Expose
        public String fixtureAwayName;
    }

    public class Score {
        @SerializedName("fullTime")
        @Expose
        public FullTime fixtureFullTime;
    }

    public class FullTime {
        @SerializedName("homeTeam")
        @Expose
        public Integer fixtureHomeWin;

        @SerializedName("awayTeam")
        @Expose
        public Integer fixtureAwayWin;
    }
}
