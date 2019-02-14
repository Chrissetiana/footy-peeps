package com.chrissetiana.footypeeps.ui.competitions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.chrissetiana.footypeeps.R;

public class CompetitionsActivity extends AppCompatActivity implements CompetitionsAdapter.ListItemClickListener {
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
