package com.chrissetiana.footypeeps.ui.competition;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chrissetiana.footypeeps.R;
import com.chrissetiana.footypeeps.data.model.standings.Standing;
import com.chrissetiana.footypeeps.data.model.standings.Standings;
import com.chrissetiana.footypeeps.data.model.standings.Table;
import com.chrissetiana.footypeeps.data.remote.ApiClient;
import com.chrissetiana.footypeeps.data.remote.ApiService;
import com.chrissetiana.footypeeps.util.standings.StandingsAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StandingsFragment extends Fragment {

    private static final String LOG_TAG = StandingsFragment.class.getSimpleName();
    private List<Standing> standingList;
    private List<Table> tableList;

    public StandingsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
            public void onResponse(Call<Standings> call, Response<Standings> response) {
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

//                    for (int i=0; i<standingList.size(); i++) {
//                        final List<Table> tableList = standingList.get(i).getTableList();
//                        StandingsFragment.this.tableList = new ArrayList<>(tableList);
//                    }
//                    there are 3 tables (total, home, away) if we use the loop
//                    so we take only the 0th one which is for the total standings

                    tableList = new ArrayList<>(standingList.get(0).getTableList());
                    Log.d(LOG_TAG, "tableList:" + tableList.size());

                    StandingsAdapter adapter = new StandingsAdapter(tableList, null);
                    list.setAdapter(adapter);

                    DividerItemDecoration divider = new DividerItemDecoration(list.getContext(), layoutManager.getOrientation());
                    list.addItemDecoration(divider);
                } else {
                    Log.w(LOG_TAG, "RESPONSE IS NULL!");
                }
            }

            @Override
            public void onFailure(Call<Standings> call, Throwable t) {
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
}
