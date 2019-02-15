package com.chrissetiana.footypeeps.util.matches;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chrissetiana.footypeeps.R;
import com.chrissetiana.footypeeps.data.model.matches.Match;
import com.chrissetiana.footypeeps.util.ListItemClickListener;

import java.util.List;
import java.util.Objects;

public class FixturesAdapter extends RecyclerView.Adapter<FixturesAdapter.FixturesViewHolder> {

    private static final String LOG_TAG = FixturesAdapter.class.getSimpleName();
    private final ListItemClickListener listener;
    private List<Match> list;
    private int itemCount;

    public FixturesAdapter(List<Match> matchList, int matchCount, ListItemClickListener clickListener) {
        list = matchList;
        itemCount = matchCount;
        listener = clickListener;

        if (list == null || itemCount == 0) {
            Log.d(LOG_TAG, "Where art thy data?");
        }
    }

    @NonNull
    @Override
    public FixturesAdapter.FixturesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new FixturesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FixturesAdapter.FixturesViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return itemCount;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.layout_matches;
    }

    class FixturesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textMatchStatus;
        TextView textMatchTime;
        TextView textMatchDay;
        TextView textHomeTeam;
        TextView textAwayTeam;
        TextView textHomeWins;
        TextView textAwayWins;

        FixturesViewHolder(View view) {
            super(view);

            textMatchStatus = view.findViewById(R.id.text_match_status);
            textMatchTime = view.findViewById(R.id.text_match_time);
            textMatchDay = view.findViewById(R.id.text_match_day);
            textHomeTeam = view.findViewById(R.id.text_home_team);
            textAwayTeam = view.findViewById(R.id.text_away_team);
            textHomeWins = view.findViewById(R.id.text_home_wins);
            textAwayWins = view.findViewById(R.id.text_away_wins);

            view.setTag(this);
            view.setOnClickListener(this);
        }

        void bind(int i) {
            String matchStatus = list.get(i).getMatchStatus();
            String matchTime = list.get(i).getMatchDate().substring(11, 16);
            Integer matchDay = list.get(i).getMatchDay();
            String matchHomeTeam = list.get(i).getMatchHomeTeam().getHomeTeamName();
            String matchAwayTeam = list.get(i).getMatchAwayTeam().getAwayTeamName();

            try {
                String matchHomeWins = String.valueOf(list.get(i).getMatchScore().getFullTime().getHomeTeamWin());
                String matchAwayWins = String.valueOf(list.get(i).getMatchScore().getFullTime().getAwayTeamWin());

                if (matchHomeWins == null || Objects.equals(matchHomeWins, "null")) {
                    matchHomeWins = "-";
                }
                textHomeWins.setText(matchHomeWins);

                if (matchAwayWins == null || Objects.equals(matchAwayWins, "null")) {
                    matchAwayWins = "-";
                }
                textAwayWins.setText(matchAwayWins);

            } catch (NullPointerException e) {
                e.printStackTrace();
            }

            textMatchStatus.setText(matchStatus);
            textMatchTime.setText(matchTime);
            textMatchDay.setText(matchDay.toString());
            textHomeTeam.setText(matchHomeTeam);
            textAwayTeam.setText(matchAwayTeam);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            int id = list.get(position).getMatchId();
            String competition = list.get(position).getMatchCompetition().getCompetitionName();
            listener.onListItemClick(position, id, competition);
        }
    }
}
