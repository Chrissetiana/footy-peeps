package com.chrissetiana.footypeeps.data.model;

public class FootyStandings {
    // for competition/standings
    // https://api.football-data.org/v2/competitions/{id}/standings
    // id is the id"" of the team
    private String position; // standings[] table[] position""
    private String team; // standings[] table[] team{} name""
    private int playedGames; // standings[] table[] playedGames#
    private int goalDifference; // standings[] table[] goalDifference#
    private int points; // standings[] table[] points#
}
