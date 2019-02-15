package com.chrissetiana.footypeeps.ui.fixtures;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.chrissetiana.footypeeps.R;

public class FixturesActivity extends AppCompatActivity implements FixturesAdapter.ListItemClickListener {

    private static final String LOG_TAG = FixturesActivity.class.getSimpleName();
    private FixturesAdapter adapter;
    private RecyclerView list;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_fixtures);

        // declare the xml elements here
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        // do action here
    }
}
