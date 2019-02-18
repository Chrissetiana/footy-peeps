package com.chrissetiana.footypeeps.util.teams;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chrissetiana.footypeeps.R;
import com.chrissetiana.footypeeps.data.model.teams.Team;
import com.chrissetiana.footypeeps.util.ListItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.TeamsViewHolder> {

    private static final String LOG_TAG = TeamsAdapter.class.getSimpleName();
    private final ListItemClickListener listener;
    private List<Team> list;
    private int itemCount;

    public TeamsAdapter(java.util.List<Team> teamList, int teamCount, ListItemClickListener clickListener) {
        list = teamList;
        itemCount = teamCount;
        listener = clickListener;

        if (list == null || itemCount == 0) {
            Log.d(LOG_TAG, "Where art thy data?");
        }
    }

    @NonNull
    @Override
    public TeamsAdapter.TeamsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new TeamsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamsAdapter.TeamsViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return itemCount;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.layout_teams;
    }

    class TeamsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageTeamCrest;
        TextView textTeamLabel;

        TeamsViewHolder(View view) {
            super(view);

            imageTeamCrest = view.findViewById(R.id.image_team_crest);
            textTeamLabel = view.findViewById(R.id.text_team_label);

            view.setTag(this);
            view.setOnClickListener(this);
        }

        void bind(int i) {
            String teamLabel = list.get(i).getTeamName();

            Picasso.get()
                    .load(list.get(i).getTeamLogo())
                    .placeholder(R.drawable.soccer_white)
                    .error(R.drawable.soccer_black)
                    .into(imageTeamCrest);
            textTeamLabel.setText(teamLabel);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            int id = list.get(position).getTeamId();
            String competition = "";
            listener.onListItemClick(position, id, competition);
        }
    }
}
