package com.chrissetiana.footypeeps.ui.players;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.chrissetiana.footypeeps.R;

public class PlayersActivity extends AppCompatActivity implements PlayersAdapter.ListItemClickListener {

    // this class should be a modal window
    private static final String LOG_TAG = PlayersActivity.class.getSimpleName();
    private PlayersAdapter adapter;
    private RecyclerView list;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_team);

        // declare the xml elements here
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        // do action here
    }
}
