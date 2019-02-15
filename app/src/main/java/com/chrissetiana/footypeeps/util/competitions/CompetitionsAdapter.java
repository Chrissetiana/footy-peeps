package com.chrissetiana.footypeeps.util.competitions;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chrissetiana.footypeeps.R;
import com.chrissetiana.footypeeps.data.model.competitions.Competition;
import com.chrissetiana.footypeeps.util.ListItemClickListener;

import java.util.List;

public class CompetitionsAdapter extends RecyclerView.Adapter<CompetitionsAdapter.CompetitionsViewHolder> {

    private static final String LOG_TAG = CompetitionsAdapter.class.getSimpleName();
    private ListItemClickListener listener;
    private List<Competition> list;
    //    private Competition[] list;
    private int itemCount;

    public CompetitionsAdapter(List<Competition> competitionList, int competitionCount, ListItemClickListener clickListener) {
//    public CompetitionsAdapter(Competition[] competitionList, int competitionCount) {
        Log.d(LOG_TAG, "This is the adapter constructor");

        list = competitionList;
        itemCount = competitionCount;
        listener = clickListener;

        if (list == null || itemCount == 0) {
            Log.d(LOG_TAG, "Where art thy data?");
        }
    }

    @NonNull
    @Override
    public CompetitionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new CompetitionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompetitionsViewHolder holder, int position) {
//        holder.bind(list.get(position));
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return itemCount;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.layout_competitions;
    }

    class CompetitionsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textCompetitionName;

        CompetitionsViewHolder(View view) {
            super(view);

            textCompetitionName = view.findViewById(R.id.text_competition_name);

            view.setTag(this);
            view.setOnClickListener(this);
        }

        void bind(int i) {
//        void bind(Competition c) {
//            String competitionName = c.getCompetitionName();
            String competitionName = list.get(i).getCompetitionName();

            textCompetitionName.setText(competitionName);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            int id = list.get(position).getCompetitionId();
            String competition = list.get(position).getCompetitionName();
            listener.onListItemClick(position, id, competition);
        }
    }
}
