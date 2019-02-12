package com.chrissetiana.footypeeps.data.local;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public class FootyContract {

    public static final String AUTHORITY = "com.chrissetiana.footypeeps.app";
    public static final String MIME_VENDOR_TYPE = "vnd." + AUTHORITY + ".";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);
    public static final String PATH = "table";

    private FootyContract() {}

    // you can have more than one inner CustomEntry classes like this
    public static final class FootyEntry implements BaseColumns {

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH);

        // these are for MIME types
        public static final String CONTENT_LIST_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + MIME_VENDOR_TYPE + PATH;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + MIME_VENDOR_TYPE + "/" + PATH;

        // declare the table name
        public static final String TABLE_NAME = "competitions";

        // declare the columns
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_COMPETITION_ID = "competitionId";
        public static final String COLUMN_COMPETITION_NAME = "competitionName";

        // declare the indexes
        public static final String INDEX_NAME = TABLE_NAME + "_index";

        // create database table
        public static final String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_COMPETITION_ID + " INTEGER NOT NULL DEFAULT 0, " +
                COLUMN_COMPETITION_NAME + " TEXT NOT NULL)";

        // create index for a specific column
        public static final String SQL_CREATE_INDEX = "CREATE INDEX " + INDEX_NAME +
                " ON " + TABLE_NAME + "(" + COLUMN_COMPETITION_NAME + ")";
    }
}
