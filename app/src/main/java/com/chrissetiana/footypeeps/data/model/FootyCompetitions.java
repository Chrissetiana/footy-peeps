package com.chrissetiana.footypeeps.data.model;

public class FootyCompetitions {
    // for competitions list
    // https://api.football-data.org/v2/competitions
    private int competitionId; // competitions[] id#
    private String competitionName; // competitions[] name""
    private String competitionCode; // competitions[] code"" (!!! SOME DO NOT HAVE CODE SO USE ID INSTEAD !!!)
    private String competitionStartDate; // competitions[] currentSeason{} startDate"" only year
    private String competitionEndDate; // competitions[] currentSeason{} endDate"" last two digits of year

    public int getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(int competitionId) {
        this.competitionId = competitionId;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getCompetitionCode() {
        return competitionCode;
    }

    public void setCompetitionCode(String competitionCode) {
        this.competitionCode = competitionCode;
    }

    public String getCompetitionStartDate() {
        return competitionStartDate;
    }

    public void setCompetitionStartDate(String competitionStartDate) {
        this.competitionStartDate = competitionStartDate;
    }

    public String getCompetitionEndDate() {
        return competitionEndDate;
    }

    public void setCompetitionEndDate(String competitionEndDate) {
        this.competitionEndDate = competitionEndDate;
    }
}
