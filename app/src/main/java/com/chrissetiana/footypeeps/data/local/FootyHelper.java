package com.chrissetiana.footypeeps.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FootyHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "footypeeps.db";

    public FootyHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public String getDatabaseName() {
        return super.getDatabaseName();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(FootyContract.FootyEntry.SQL_CREATE_TABLE);
        db.execSQL(FootyContract.FootyEntry.SQL_CREATE_INDEX);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
