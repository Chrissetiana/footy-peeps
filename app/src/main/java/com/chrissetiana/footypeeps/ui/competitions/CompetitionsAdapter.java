package com.chrissetiana.footypeeps.ui.competitions;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CompetitionsAdapter extends RecyclerView.Adapter<CompetitionsAdapter.CompetitionsViewHolder> {

    private final ListItemClickListener listener;
    private int holderCount;
    private int itemCount;

    public CompetitionsAdapter(int items, ListItemClickListener clickListener) {
        itemCount = items;
        listener = clickListener;
        holderCount = 0;
    }

    @Override
    public CompetitionsAdapter.CompetitionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new CompetitionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CompetitionsAdapter.CompetitionsViewHolder viewHolder, int position) {
        viewHolder.bind(position);
    }

    @Override
    public int getItemCount() {
        return itemCount;
    }

    @Override
    public int getItemViewType(int position) {
        return android.R.layout.simple_list_item_1;
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

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }
}
