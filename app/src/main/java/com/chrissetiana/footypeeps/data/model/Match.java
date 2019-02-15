package com.chrissetiana.footypeeps.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Match {
    // for competition/matches
    // https://api.football-data.org/v2/competitions/{id}/matches

    @SerializedName("id")
    @Expose
    public Integer matchId;

    @SerializedName("competition")
    @Expose
    public Competition matchCompetition;

    @SerializedName("status")
    @Expose
    public String matchStatus;

    @SerializedName("matchday")
    @Expose
    public Integer matchDay;

    @SerializedName("homeTeam")
    @Expose
    public HomeTeam matchHomeTeam;

    @SerializedName("awayTeam")
    @Expose
    public AwayTeam matchAwayTeam;

    @SerializedName("score")
    @Expose
    public Score matchScore;

    public Match(Integer matchId, Competition matchCompetition, String matchStatus, Integer matchDay,
                 HomeTeam matchHomeTeam, AwayTeam matchAwayTeam, Score matchScore) {
        this.matchId = matchId;
        this.matchCompetition = matchCompetition;
        this.matchStatus = matchStatus;
        this.matchDay = matchDay;
        this.matchHomeTeam = matchHomeTeam;
        this.matchAwayTeam = matchAwayTeam;
        this.matchScore = matchScore;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Competition getMatchCompetition() {
        return matchCompetition;
    }

    public void setMatchCompetition(Competition matchCompetition) {
        this.matchCompetition = matchCompetition;
    }

    public String getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(String matchStatus) {
        this.matchStatus = matchStatus;
    }

    public Integer getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(Integer matchDay) {
        this.matchDay = matchDay;
    }

    public HomeTeam getMatchHomeTeam() {
        return matchHomeTeam;
    }

    public void setMatchHomeTeam(HomeTeam matchHomeTeam) {
        this.matchHomeTeam = matchHomeTeam;
    }

    public AwayTeam getMatchAwayTeam() {
        return matchAwayTeam;
    }

    public void setMatchAwayTeam(AwayTeam matchAwayTeam) {
        this.matchAwayTeam = matchAwayTeam;
    }

    public Score getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(Score matchScore) {
        this.matchScore = matchScore;
    }
}
