package com.chrissetiana.footypeeps.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.chrissetiana.footypeeps.R;
import com.chrissetiana.footypeeps.ui.competitions.CompetitionsActivity;
import com.chrissetiana.footypeeps.ui.matches.FixturesActivity;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkConnection();
        init();
    }

    private void checkConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        assert networkInfo != null;

        if (networkInfo == null && !networkInfo.isConnected()) {
            AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Connection Failed")
                    .setMessage("Check your connection and try again.")
                    .setNeutralButton("Dismiss", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            checkConnection();
                        }
                    });
            myAlertBuilder.show();
        } else {
            Log.d(LOG_TAG, "CONNECTED");
        }
    }

    private void init() {
        ActionBar toolbar = getSupportActionBar();

        final int navCompetitions = R.id.navigation_competitions;
        final int navFixtures = R.id.navigation_fixtures;

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                int id = item.getItemId();
                assert toolbar != null;

                switch (id) {
                    case navCompetitions:
                        Log.d(LOG_TAG, "Competitions tab selected");
                        toolbar.setTitle(R.string.navigation_competitions);
                        fragment = new CompetitionsActivity();
                        loadFragment(fragment);
                        break;
                    case navFixtures:
                    default:
                        Log.d(LOG_TAG, " Fixtures tab selected");
                        toolbar.setTitle(R.string.navigation_fixtures);
                        fragment = new FixturesActivity();
                        loadFragment(fragment);
                        break;
                }
                return true;
            }
        });
        bottomNavigation.setSelectedItemId(navFixtures);
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
