package com.chrissetiana.footypeeps.data.remote;

import com.chrissetiana.footypeeps.data.model.competitions.Competitions;
import com.chrissetiana.footypeeps.data.model.matches.Matches;
import com.chrissetiana.footypeeps.data.model.standings.Standings;
import com.chrissetiana.footypeeps.data.model.teams.Team;
import com.chrissetiana.footypeeps.data.model.teams.Teams;
import com.chrissetiana.footypeeps.util.Config;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ApiService {

    @Headers(Config.BASE_KEY)
    @GET("/v2/competitions")
    Call<Competitions> getCompetitions();

    @Headers(Config.BASE_KEY)
    @GET("/v2/matches")
    Call<Matches> getFixtures();

    @Headers(Config.BASE_KEY)
    @GET("/v2/competitions/{id}/matches")
    Call<Matches> getMatches(@Path("id") int id);

    @Headers(Config.BASE_KEY)
    @GET("/v2/competitions/{id}/standings")
    Call<Standings> getStandings(@Path("id") int id);

    @Headers(Config.BASE_KEY)
    @GET("/v2/competitions/{id}/teams")
    Call<Teams> getTeams(@Path("id") int id);

    @Headers(Config.BASE_KEY)
    @GET("/v2/teams/{id}")
    Call<Team> getPlayers(@Path("id") int id);
}
