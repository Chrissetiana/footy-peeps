package com.chrissetiana.footypeeps.ui.fixtures;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.chrissetiana.footypeeps.R;
import com.chrissetiana.footypeeps.ui.competitions.CompetitionsAdapter;

public class FixturesActivity extends AppCompatActivity implements CompetitionsAdapter.ListItemClickListener {
    CompetitionsAdapter adapter;
    RecyclerView list;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);

        // declare the xml elements here
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        // do action here
    }
}
