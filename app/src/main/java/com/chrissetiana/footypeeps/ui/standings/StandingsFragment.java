package com.chrissetiana.footypeeps.ui.standings;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chrissetiana.footypeeps.R;
import com.chrissetiana.footypeeps.data.model.standings.Standing;
import com.chrissetiana.footypeeps.data.model.standings.Standings;
import com.chrissetiana.footypeeps.data.model.standings.Table;
import com.chrissetiana.footypeeps.data.remote.ApiClient;
import com.chrissetiana.footypeeps.data.remote.ApiService;
import com.chrissetiana.footypeeps.ui.competitions.CompetitionActivity;
import com.chrissetiana.footypeeps.util.ListItemClickListener;
import com.chrissetiana.footypeeps.util.standings.StandingsAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StandingsFragment extends Fragment implements ListItemClickListener {

    private static final String LOG_TAG = StandingsFragment.class.getSimpleName();
    private List<Standing> standingList;
    private List<Table> tableList;

    public StandingsFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_standings, container, false);

        Log.d(LOG_TAG, LOG_TAG + " ACTIVE");

        CompetitionActivity competitionActivity = (CompetitionActivity) getActivity();
        int competitionId = competitionActivity.getCompetitionId();

        RecyclerView list = view.findViewById(R.id.list_competition_standings);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        list.setLayoutManager(layoutManager);
        list.setHasFixedSize(true);
        list.setItemAnimator(new DefaultItemAnimator());

        ApiService apiService = ApiClient.getClient().create(ApiService.class);

        Call<Standings> call = apiService.getStandings(competitionId);
        call.enqueue(new Callback<Standings>() {
            @Override
            public void onResponse(@NonNull Call<Standings> call, @NonNull Response<Standings> response) {
                if (!response.isSuccessful()) {
                    Log.e(LOG_TAG, "FAILED CONNECTION with code " + response.code() + ": " + response.errorBody());
                    return;
                }

                Log.d(LOG_TAG, "SUCCESSFUL CONNECTION with code " + response.code());

                final Standings res = response.body();

                if (res != null) {
                    Log.d(LOG_TAG, "Data received from " + response.body().toString());

                    standingList = new ArrayList<>(res.getStandingList());
                    Log.d(LOG_TAG, "standingList:" + standingList.size());

                    tableList = new ArrayList<>(standingList.get(0).getTableList());
                    Log.d(LOG_TAG, "tableList:" + tableList.size());

                    StandingsAdapter adapter = new StandingsAdapter(tableList, StandingsFragment.this);
                    list.setAdapter(adapter);

                    DividerItemDecoration divider = new DividerItemDecoration(list.getContext(), layoutManager.getOrientation());
                    list.addItemDecoration(divider);
                } else {
                    Log.w(LOG_TAG, "RESPONSE IS NULL!");
                }
            }

            @Override
            public void onFailure(@NonNull Call<Standings> call, @NonNull Throwable t) {
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
    }
}
