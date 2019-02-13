package com.chrissetiana.footypeeps.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.chrissetiana.footypeeps.R;
import com.chrissetiana.footypeeps.data.model.Competitions;
import com.chrissetiana.footypeeps.data.model.Teams;
import com.chrissetiana.footypeeps.data.remote.ApiClient;
import com.chrissetiana.footypeeps.data.remote.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private int statusCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiService apiService = ApiClient.getClient(ApiService.class);

        Call<Competitions> competitions = apiService.getCompetitions();
        competitions.enqueue(new Callback<Competitions>() {
            @Override
            public void onResponse(Call<Competitions> call, Response<Competitions> response) {
                res(response);
            }

            @Override
            public void onFailure(Call<Competitions> call, Throwable t) {
                call.cancel();
                t.printStackTrace();
            }
        });

        Call<List<Teams>> teams = apiService.getTeams(2021, "Premier League");
        teams.enqueue(new Callback<List<Teams>>() {
            @Override
            public void onResponse(Call<List<Teams>> call, Response<List<Teams>> response) {

            }

            @Override
            public void onFailure(Call<List<Teams>> call, Throwable t) {

            }
        });
    }

    private void res(Response<Competitions> response) {
        if(response.isSuccessful()) {
            Log.d("Main Activity", "SUCCESSFUL CONNECTION with response code " + response.code());
        } else {
            Log.d("Main Activity", "FAILED CONNECTION with response code " + response.code() + "\n" + response.errorBody());
        }
    }
}
