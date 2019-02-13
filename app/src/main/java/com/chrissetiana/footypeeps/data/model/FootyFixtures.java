package com.chrissetiana.footypeeps.data.model;

public class FootyFixtures {
    // for matches (fixtures) list
    // https://api.football-data.org/v2/matches
    private int matchId; // matches[] id#
    private String matchStatus; // matches[] status""
    private String matchStart; // matches[] season{} startDate""
    private String matchEnd; // matches[] season{} endDate""
    private int matchDay; // matches[] matchday# OR matches[] season{} currentMatchday#
    private String homeTeam; // matches[] homeTeam{} name""
    private String awayTeam; // matches[] awayTeam{} name""
    private int homeWins; // matches[] score{} fullTime{} homeTeam#
    private int awayWins; // matches[] score{} fullTime{} awayTeam#
    private String num00; // matches[]
}
