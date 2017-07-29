package com.lroxima.body_health.bodyhealth;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    // Database
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "sample_database";

    // Table
    public static final String TABLE_NAME = "body_data";
    public static final String KEY_ID = "id";
    public static final String KEY_DATE = "date";
    public static final String KEY_WEIGHT_METRIC = "weight_metric";
    public static final String KEY_WEIGHT = "weight";
    public static final String KEY_BODY_FAT = "body_fat";
    public static final String KEY_WATER = "water";
    public static final String KEY_BONE = "bone";
    public static final String KEY_BMI = "bmi";

    private static final String DICTIONARY_TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME  + " ( " + KEY_ID + " INTEGER PRIMARY KEY, " +
                    KEY_DATE  + " DATE, " + KEY_WEIGHT_METRIC + " INT UNSIGNED, " +
                    KEY_WEIGHT + " INT UNSIGNED, " + KEY_BODY_FAT + " INT UNSIGNED, " +
                    KEY_WATER + " INT UNSIGNED, " + KEY_BONE + " INT UNSIGNED, " +
                    KEY_BODY_FAT + " INT UNSIGNED,);";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DICTIONARY_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}