package com.chrissetiana.footypeeps.data.remote;

import com.chrissetiana.footypeeps.data.model.Competitions;
import com.chrissetiana.footypeeps.data.model.Fixtures;
import com.chrissetiana.footypeeps.data.model.Matches;
import com.chrissetiana.footypeeps.data.model.Players;
import com.chrissetiana.footypeeps.data.model.Standings;
import com.chrissetiana.footypeeps.data.model.Teams;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ApiService {

    @Headers("X-Auth-Token: d1ba213481124ac484aba62428f9f60b")
    @GET("/v2/competitions")
    Call<Competitions> getCompetitions();

    @Headers("X-Auth-Token: d1ba213481124ac484aba62428f9f60b")
    @GET("/v2/matches")
    Call<Fixtures> getFixtures();

    @Headers("X-Auth-Token: d1ba213481124ac484aba62428f9f60b")
    @GET("/v2/competitions/{id}/matches")
    Call<List<Matches>> getMatches(@Path("id") int id);

    @Headers("X-Auth-Token: d1ba213481124ac484aba62428f9f60b")
    @GET("/v2/teams/{id}")
    Call<List<Players>> getPlayers(@Path("id") int id);

    @Headers("X-Auth-Token: d1ba213481124ac484aba62428f9f60b")
    @GET("/v2/competitions/{id}/standings")
    Call<Standings> getStandings(@Path("id") int id);

    @Headers("X-Auth-Token: d1ba213481124ac484aba62428f9f60b")
    @GET("/v2/competitions/{id}/teams")
    Call<List<Teams>> getTeams(@Path("id") int id);
}
