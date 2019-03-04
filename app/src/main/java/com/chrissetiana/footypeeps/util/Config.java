package com.chrissetiana.footypeeps.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Config {

    public static final String PACKAGE_NAME = "com.chrissetiana.footypeeps";
    public static final String BASE_URL = "https://api.football-data.org";
    public static final String BASE_KEY = "X-Auth-Token: d1ba213481124ac484aba62428f9f60b";
    public static final String DATABASE_NAME = "FootyPeeps.db";

    private static Config instance = new Config();
    private static Context context;

    public static Config getInstance(Context c) {
        context = c.getApplicationContext();
        return instance;
    }

    public boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnected();
    }
}
