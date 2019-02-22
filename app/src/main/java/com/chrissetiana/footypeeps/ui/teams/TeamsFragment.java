package com.chrissetiana.footypeeps.ui.teams;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chrissetiana.footypeeps.R;
import com.chrissetiana.footypeeps.data.model.teams.Team;
import com.chrissetiana.footypeeps.data.model.teams.Teams;
import com.chrissetiana.footypeeps.data.remote.ApiClient;
import com.chrissetiana.footypeeps.data.remote.ApiService;
import com.chrissetiana.footypeeps.ui.competitions.CompetitionActivity;
import com.chrissetiana.footypeeps.util.ListItemClickListener;
import com.chrissetiana.footypeeps.util.remote.teams.TeamsAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamsFragment extends Fragment implements ListItemClickListener {

    private static final String LOG_TAG = TeamsFragment.class.getSimpleName();
    private static final int SPAN_COUNT = 2;
    private List<Team> teamList;

    public TeamsFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_teams, container, false);

        Log.d(LOG_TAG, LOG_TAG + " ACTIVE");

        CompetitionActivity competitionActivity = (CompetitionActivity) getActivity();
        int competitionId = competitionActivity.getCompetitionId();

        RecyclerView list = view.findViewById(R.id.list_competition_teams);

        GridLayoutManager layoutManager = new GridLayoutManager(this.getActivity(), SPAN_COUNT);
        list.setLayoutManager(layoutManager);
        list.setHasFixedSize(true);
        list.setItemAnimator(new DefaultItemAnimator());

        ApiService apiService = ApiClient.getClient().create(ApiService.class);

        Call<Teams> call = apiService.getTeams(competitionId);
        call.enqueue(new Callback<Teams>() {
            @Override
            public void onResponse(@NonNull Call<Teams> call, @NonNull Response<Teams> response) {
                if (!response.isSuccessful()) {
                    Log.e(LOG_TAG, "FAILED CONNECTION with code " + response.code() + ": " + response.errorBody());
                    return;
                }

                Log.d(LOG_TAG, "SUCCESSFUL CONNECTION with code " + response.code());

                final Teams res = response.body();

                if (res != null) {
                    Log.d(LOG_TAG, "Data received from " + response.body().toString());

                    teamList = new ArrayList<>(res.getTeamList());
                    Log.d(LOG_TAG, "matchList:" + teamList.size());

                    TeamsAdapter adapter = new TeamsAdapter(TeamsFragment.this.getActivity(), teamList, TeamsFragment.this);
                    list.setAdapter(adapter);
                } else {
                    Log.w(LOG_TAG, "RESPONSE IS NULL!");
                }
            }

            @Override
            public void onFailure(@NonNull Call<Teams> call, @NonNull Throwable t) {
                try {
                    Log.e(LOG_TAG, "QUERY FAILED: " + t.toString() + " >>> CAUSED BY: " + t.getCause());
                    throw t;
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        });

        return view;
    }

    @Override
    public void onListItemClick(int clickedItemIndex, int clickedItemId, String clickedItemName) {
        String msg = "Item #" + clickedItemIndex + " [" + clickedItemName + "] with id of " + clickedItemId + " clicked.";
        Log.d(LOG_TAG, msg);
        Toast.makeText(this.getActivity(), msg, Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this.getActivity(), PlayersActivity.class);
        intent.putExtra("teamId", clickedItemId);
        intent.putExtra("teamName", clickedItemName);
        startActivity(intent);
    }
}
