package com.chrissetiana.footypeeps.data.local;

import android.arch.persistence.room.Room;
import android.content.Context;

public class DbClient {

    private static DbClient instance;
    private Context context;
    private DbClass database;

    private DbClient(Context context) {
        this.context = context;

        database = Room.databaseBuilder(context, DbClass.class, DbClass.DB_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries() // to allow making requests in the main thread ONLY FOR TESTING
                .build();
    }

    public static synchronized DbClient getInstance(Context context) {
        if (instance == null) {
            instance = new DbClient(context);
        }

        return instance;
    }

    public DbClass getDatabase() {
        return database;
    }

    public void destroyInstance() {
        instance = null;
    }
}