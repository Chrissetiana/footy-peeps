package com.chrissetiana.footypeeps.ui.competitions;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.chrissetiana.footypeeps.R;
import com.chrissetiana.footypeeps.util.CompetitionAdapter;

public class CompetitionActivity extends AppCompatActivity {

    private int competitionId;

    public int getCompetitionId() {
        return competitionId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competition);

        Intent intent = getIntent();
        competitionId = intent.getIntExtra("competitionId", 0);
        String competitionName = intent.getStringExtra("competitionName");

        ActionBar toolbar = getSupportActionBar();
        toolbar.setTitle(competitionName);
        toolbar.setDisplayHomeAsUpEnabled(true);

        CompetitionAdapter adapter = new CompetitionAdapter(this, getSupportFragmentManager());

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
