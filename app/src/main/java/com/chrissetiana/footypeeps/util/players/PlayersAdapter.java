package com.chrissetiana.footypeeps.util.players;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chrissetiana.footypeeps.R;
import com.chrissetiana.footypeeps.data.model.teams.Squad;
import com.chrissetiana.footypeeps.util.ListItemClickListener;

import java.util.List;
import java.util.Objects;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.PlayersViewHolder> {

    private static final String LOG_TAG = PlayersAdapter.class.getSimpleName();
    private final ListItemClickListener listener;
    private List<Squad> list;

    public PlayersAdapter(List<Squad> squadList, ListItemClickListener clickListener) {
        list = squadList;
        listener = clickListener;

        if (list == null) {
            Log.d(LOG_TAG, "Where art thy data?");
        }
    }

    @NonNull
    @Override
    public PlayersAdapter.PlayersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new PlayersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayersAdapter.PlayersViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.layout_players;
    }

    class PlayersViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textPlayerNo;
        TextView textPlayerName;
        TextView textPlayerPosition;

        PlayersViewHolder(View view) {
            super(view);

            textPlayerNo = view.findViewById(R.id.text_player_no);
            textPlayerName = view.findViewById(R.id.text_player_name);
            textPlayerPosition = view.findViewById(R.id.text_player_position);

            view.setTag(this);
            view.setOnClickListener(this);
        }

        void bind(int i) {
            String playerName = list.get(i).getPlayerName();
            String playerPosition = list.get(i).getPlayerPosition();

            try {
                String playerNumber = String.valueOf(list.get(i).getPlayerShirtNumber());

                if (playerNumber == null || Objects.equals(playerNumber, "null")) {
                    playerNumber = "-";
                }
                textPlayerNo.setText(playerNumber);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }

            textPlayerName.setText(playerName);
            textPlayerPosition.setText(playerPosition);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            int id = list.get(position).getPlayerId();
            String competition = "";
            listener.onListItemClick(position, id, competition);
        }
    }
}
