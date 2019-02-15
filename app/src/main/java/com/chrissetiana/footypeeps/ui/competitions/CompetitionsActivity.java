package com.chrissetiana.footypeeps.ui.competitions;

import android.content.Intent;
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

import com.chrissetiana.footypeeps.R;
import com.chrissetiana.footypeeps.data.model.competitions.Competition;
import com.chrissetiana.footypeeps.data.model.competitions.Competitions;
import com.chrissetiana.footypeeps.data.remote.ApiClient;
import com.chrissetiana.footypeeps.data.remote.ApiService;
import com.chrissetiana.footypeeps.ui.competition.CompetitionActivity;
import com.chrissetiana.footypeeps.util.ListItemClickListener;
import com.chrissetiana.footypeeps.util.competitions.CompetitionsAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompetitionsActivity extends Fragment implements ListItemClickListener {

    // anywhere you call findViewById() you will need to use view.findViewById()
    // replace `this` with getActivity()

    private static final String LOG_TAG = CompetitionsActivity.class.getSimpleName();
    private List<Competition> competitionList;
    private int itemCount;
    //    private Competition[] competitionList;

    public CompetitionsActivity() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_competitions, container, false);

        Log.d(LOG_TAG, LOG_TAG + " ACTIVE");

        RecyclerView list = view.findViewById(R.id.list_competitions);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        list.setLayoutManager(layoutManager);
        list.setHasFixedSize(true);
        list.setItemAnimator(new DefaultItemAnimator());

        ApiService apiService = ApiClient.getClient().create(ApiService.class);

        Call<Competitions> call = apiService.getCompetitions();
        call.enqueue(new Callback<Competitions>() {
            @Override
            public void onResponse(@NonNull Call<Competitions> call, @NonNull final Response<Competitions> response) {
                if (!response.isSuccessful()) {
                    Log.e(LOG_TAG, "FAILED CONNECTION with code " + response.code() + ": " + response.errorBody());
                    return;
                }

                Log.d(LOG_TAG, "SUCCESSFUL CONNECTION with code " + response.code());

                final Competitions res = response.body();

                if (res != null) {
                    Log.d(LOG_TAG, "Data received from " + response.body().toString());

                    itemCount = res.getCountCompetitions();
                    Log.d(LOG_TAG, "itemCount:" + itemCount);

                    competitionList = new ArrayList<>(res.getCompetitionList());
//                   competitionList = res.getCompetitionList();
//                   competitionList = res.getCompetitionList();
                    Log.d(LOG_TAG, "competitionList:" + competitionList.size());

                    CompetitionsAdapter adapter = new CompetitionsAdapter(competitionList, itemCount, CompetitionsActivity.this);
                    list.setAdapter(adapter);

                    DividerItemDecoration divider = new DividerItemDecoration(list.getContext(), layoutManager.getOrientation());
                    list.addItemDecoration(divider);
                } else {
                    Log.w(LOG_TAG, "RESPONSE IS NULL!");
                }
            }

            @Override
            public void onFailure(@NonNull Call<Competitions> call, @NonNull Throwable t) {
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
    public void onListItemClick(int clickedItemIndex, int clickedItemId, String clickedItemCompetition) {
        Log.d(LOG_TAG, "Item #" + clickedItemIndex + "[" + clickedItemCompetition + "]" +
                " with id of " + clickedItemId + " clicked.");

        Intent intent = new Intent(this.getActivity(), CompetitionActivity.class);
        intent.putExtra("competitionId", clickedItemId);
        intent.putExtra("competitionName", clickedItemCompetition);
        startActivity(intent);
    }
}
