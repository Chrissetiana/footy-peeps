package com.chrissetiana.footypeeps.util.competitions;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chrissetiana.footypeeps.R;

public class CompetitionsAdapter extends RecyclerView.Adapter<CompetitionsAdapter.CompetitionsViewHolder> {

    private static final String LOG_TAG = CompetitionsAdapter.class.getSimpleName();
    private final ListItemClickListener listener;
    private int holderCount;
    private int itemCount;

    public CompetitionsAdapter(int items, ListItemClickListener clickListener) {
        itemCount = items;
        listener = clickListener;
        holderCount = 0;
    }

    @Override
    public CompetitionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new CompetitionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CompetitionsViewHolder viewHolder, int position) {
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

    class CompetitionsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // declare ui var e.g. TextView text;

        CompetitionsViewHolder(View view) {
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
