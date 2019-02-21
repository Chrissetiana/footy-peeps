package com.chrissetiana.footypeeps.util.local.standings;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chrissetiana.footypeeps.R;

public class StandingsPresenter extends RecyclerView.Adapter<StandingsPresenter.StandingsViewHolder> {

    private static final String LOG_TAG = StandingsPresenter.class.getSimpleName();
    private final ListItemClickListener listener;
    private int holderCount;
    private int itemCount;

    public StandingsPresenter(int items, ListItemClickListener clickListener) {
        itemCount = items;
        listener = clickListener;
        holderCount = 0;
    }

    @Override
    public StandingsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new StandingsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StandingsViewHolder viewHolder, int position) {
        viewHolder.bind(position);
    }

    @Override
    public int getItemCount() {
        return itemCount;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.layout_competitions;
    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    class StandingsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // declare ui var e.g. TextView text;

        StandingsViewHolder(View view) {
            super(view);
            // initialize ui var e.g. text = view.findByViewId(R.id.);
            view.setOnClickListener(this);
        }

        void bind(int position) {
            // update the ui e.g. text.setText(String.valueOf(index));
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            listener.onListItemClick(position);
        }
    }
}
