package com.chrissetiana.footypeeps.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectivityStatus {

    private static ConnectivityStatus instance = new ConnectivityStatus();
    private static Context context;

    public static ConnectivityStatus getInstance(Context c) {
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
