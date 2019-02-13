package com.chrissetiana.footypeeps.data.model;

public class FootyMatches {
    // for competition/matches
    // https://api.football-data.org/v2/competitions/{id}/matches
    // e.g. https://api.football-data.org/v2/competitions/2021/matches
    // e.g. https://api.football-data.org/v2/competitions/PL/matches
    private int teamMatchId; // matches[] id#
    private String teamMatchStatus; // matches[] status""
    private String teamMatchStart; // matches[] season{} startDate""
    private String teamMatchEnd; // matches[] season{} endDate""
    private int teamMatchDay; // matches[] matchday# OR matches[] season{} currentMatchday#
    private String teamMatchHomeTeam; // matches[] homeTeam{} name""
    private String teamMatchAwayTeam; // matches[] awayTeam{} name""
    private int teamMatchHomeWins; // matches[] score{} fullTime{} homeTeam#
    private int teamMatchAwayWins; // matches[] score{} fullTime{} awayTeam#
    private String teamMatchNum00; // matches[]
}
