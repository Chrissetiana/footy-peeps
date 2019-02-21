package com.chrissetiana.footypeeps.util.remote.standings;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chrissetiana.footypeeps.R;
import com.chrissetiana.footypeeps.data.model.standings.Table;
import com.chrissetiana.footypeeps.util.ListItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StandingsAdapter extends RecyclerView.Adapter<StandingsAdapter.StandingsViewHolder> {

    private static final String LOG_TAG = StandingsAdapter.class.getSimpleName();
    private final ListItemClickListener listener;
    private List<Table> list;

    public StandingsAdapter(List<Table> standingList, ListItemClickListener clickListener) {
        list = standingList;
        listener = clickListener;

        if (list == null) {
            Log.d(LOG_TAG, "Where art thy data?");
        }
    }

    @NonNull
    @Override
    public StandingsAdapter.StandingsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new StandingsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StandingsAdapter.StandingsViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.layout_standings;
    }

    class StandingsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageStandingTeam;
        TextView textTeamPosition;
        TextView textTeamName;
        TextView textTeamPlayed;
        TextView textTeamDifference;
        TextView textTeamPoints;

        StandingsViewHolder(View view) {
            super(view);

            imageStandingTeam = view.findViewById(R.id.image_team_logo);
            textTeamPosition = view.findViewById(R.id.text_table_position);
            textTeamName = view.findViewById(R.id.text_team_name);
            textTeamPlayed = view.findViewById(R.id.text_team_played);
            textTeamDifference = view.findViewById(R.id.text_team_difference);
            textTeamPoints = view.findViewById(R.id.text_team_points);

            view.setTag(this);
            view.setOnClickListener(this);
        }

        void bind(int i) {
            Integer teamPosition = list.get(i).getTablePosition();
            String teamName = list.get(i).getTableTeam().getTeamName();
            Integer teamPlayed = list.get(i).getTablePlayed();
            Integer teamDifference = list.get(i).getTableDifference();
            Integer teamPoints = list.get(i).getTablePoints();

            Picasso.get()
                    .load(list.get(i).getTableTeam().getTeamLogo())
                    .placeholder(R.drawable.soccer_white)
                    .error(R.drawable.soccer_black)
                    .into(imageStandingTeam);
            textTeamPosition.setText(String.format("%d", teamPosition));
            textTeamName.setText(teamName);
            textTeamPlayed.setText(String.format("%d", teamPlayed));
            textTeamDifference.setText(String.format("%d", teamDifference));
            textTeamPoints.setText(String.format("%d", teamPoints));
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            int id = list.get(position).getTableTeam().getTeamId();
            String name = list.get(position).getTableTeam().getTeamName();
            listener.onListItemClick(position, id, name);
        }
    }
}
