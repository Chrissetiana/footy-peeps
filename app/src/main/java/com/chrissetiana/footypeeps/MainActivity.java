package com.chrissetiana.footypeeps;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.chrissetiana.footypeeps.data.remote.ApiClient;
import com.chrissetiana.footypeeps.data.remote.ApiService;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private ActionBar toolBar;

    // this class should not have logic (i.e. condition, loops, etc)
    // here you can connect to listeners, adapters, etc.
    // basically just displaying and updating the ui

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolBar = getSupportActionBar();

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            ApiService apiService = ApiClient.getClient(ApiService.class);
        } else {
            // progressBar.setVisibility(View.INVISIBLE);
            // textEmpty.setVisibility(View.VISIBLE);
            // textEmpty.setText(getString(R.string.no_conn));
            Log.d(LOG_TAG, "NO CONNECTION");
        }

        // call the xml elements in init();
        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                switch (id) {
                    case R.id.navigation_fixtures:
                        toolBar.setTitle(R.string.navigation_fixtures);
                        Toast.makeText(MainActivity.this, "Fixtures selected", Toast.LENGTH_SHORT).show();
                        Log.d(LOG_TAG, " Fixtures tab selected");
                        return true;
                    case R.id.navigation_competitions:
                        toolBar.setTitle(R.string.navigation_competitions);
                        Toast.makeText(MainActivity.this, "Competitions selected", Toast.LENGTH_SHORT).show();
                        Log.d(LOG_TAG, "Competitions tab selected");
                        return true;
                }

                return false;
            }
        });
    }
}
