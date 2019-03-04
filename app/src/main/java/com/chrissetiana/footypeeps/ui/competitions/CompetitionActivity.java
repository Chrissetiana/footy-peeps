package com.chrissetiana.footypeeps.ui.competitions;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.chrissetiana.footypeeps.R;
import com.chrissetiana.footypeeps.util.competitions.CompetitionAdapter;

public class CompetitionActivity extends AppCompatActivity {

    private static final String KEY_ID = "competition_id";
    private static final String KEY_NAME = "competition_name";
    private int competitionId;
    private String competitionName;

    public int getCompetitionId() {
        return competitionId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competition);

        Intent intent = getIntent();
        competitionId = intent.getIntExtra("competitionId", 0);
        competitionName = intent.getStringExtra("competitionName");

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(KEY_ID)) {
                competitionId = savedInstanceState.getInt(KEY_ID);
            }

            if (savedInstanceState.containsKey(KEY_NAME)) {
                competitionName = savedInstanceState.getString(KEY_NAME);
            }
        }

        ActionBar toolbar = getSupportActionBar();
        toolbar.setTitle(competitionName);

        CompetitionAdapter adapter = new CompetitionAdapter(this, getSupportFragmentManager());

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);

        bundle.putInt(KEY_ID, competitionId);
        bundle.putString(KEY_NAME, competitionName);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
