package com.chrissetiana.footypeeps.ui.teams;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.chrissetiana.footypeeps.R;
import com.chrissetiana.footypeeps.data.model.teams.Squad;
import com.chrissetiana.footypeeps.data.model.teams.Team;
import com.chrissetiana.footypeeps.data.remote.ApiClient;
import com.chrissetiana.footypeeps.data.remote.ApiService;
import com.chrissetiana.footypeeps.util.ListItemClickListener;
import com.chrissetiana.footypeeps.util.teams.PlayersAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayersActivity extends AppCompatActivity implements ListItemClickListener {

    // this class should be a modal window
    private static final String LOG_TAG = PlayersActivity.class.getSimpleName();
    private List<Squad> squadList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        Log.d(LOG_TAG, LOG_TAG + " ACTIVE");

        Intent intent = getIntent();
        int teamId = intent.getIntExtra("teamId", 0);
        String teamName = intent.getStringExtra("teamName");

        ActionBar toolbar = getSupportActionBar();
        toolbar.setTitle(teamName);

        RecyclerView list = findViewById(R.id.list_team_members);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);
        list.setHasFixedSize(true);
        list.setItemAnimator(new DefaultItemAnimator());

        ApiService apiService = ApiClient.getClient().create(ApiService.class);

        Call<Team> call = apiService.getPlayers(teamId);
        call.enqueue(new Callback<Team>() {
            @Override
            public void onResponse(@NonNull Call<Team> call, @NonNull Response<Team> response) {
                if (!response.isSuccessful()) {
                    Log.e(LOG_TAG, "FAILED CONNECTION with code " + response.code() + ": " + response.errorBody());
                    return;
                }

                Log.d(LOG_TAG, "SUCCESSFUL CONNECTION with code " + response.code());

                final Team res = response.body();

                if (res != null) {
                    Log.d(LOG_TAG, "Data received from " + response.body().toString());

                    squadList = new ArrayList<>(res.getSquadList());
                    Log.d(LOG_TAG, "matchList:" + squadList.size());

                    PlayersAdapter adapter = new PlayersAdapter(squadList, PlayersActivity.this);
                    list.setAdapter(adapter);

                    DividerItemDecoration divider = new DividerItemDecoration(list.getContext(), layoutManager.getOrientation());
                    list.addItemDecoration(divider);
                } else {
                    Log.w(LOG_TAG, "RESPONSE IS NULL!");
                }
            }

            @Override
            public void onFailure(@NonNull Call<Team> call, @NonNull Throwable t) {
                try {
                    Log.e(LOG_TAG, "QUERY FAILED: " + t.toString() + " >>> CAUSED BY: " + t.getCause());
                    throw t;
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onListItemClick(int clickedItemIndex, int clickedItemId, String clickedItemName) {
        String msg = "Item #" + clickedItemIndex + " [" + clickedItemName + "] with id of " + clickedItemId + " clicked.";
        Log.d(LOG_TAG, msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

}
