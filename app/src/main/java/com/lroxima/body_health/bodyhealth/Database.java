package com.lroxima.body_health.bodyhealth;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    // Database
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "sample_database.db";

    // Table
    private static final String TABLE_NAME = "body_data";
    private static final String KEY_ID = "id";
    private static final String KEY_DATE = "date";
    private static final String KEY_WEIGHT_METRIC = "weight_metric";
    private static final String KEY_WEIGHT = "weight";
    private static final String KEY_BODY_FAT = "body_fat";
    private static final String KEY_WATER = "water";
    private static final String KEY_BONE = "bone";
    private static final String KEY_BMI = "bmi";

    private static final String DICTIONARY_TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME  + " ( " + KEY_ID + " INTEGER PRIMARY KEY, " +
                    KEY_DATE  + " DATE, " + KEY_WEIGHT_METRIC + " REAL UNSIGNED, " +
                    KEY_WEIGHT + " INT UNSIGNED, " + KEY_BMI + " REAL UNSIGNED, " +
                    KEY_BODY_FAT + " REAL UNSIGNED, " + KEY_WATER + " REAL UNSIGNED, " +
                    KEY_BONE + " REAL UNSIGNEDgit );";

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

    public void addRecord(Entry entry)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_DATE, entry.getDate());
        values.put(KEY_WEIGHT_METRIC,entry.getWeightMetric());
        values.put(KEY_WEIGHT,entry.getWeight());
        values.put(KEY_BODY_FAT,entry.getBodyFat());
        values.put(KEY_WATER,entry.getBone());
        values.put(KEY_BONE,entry.getBone());
        values.put(KEY_BMI,entry.getBmi());

        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public int updateRecord(Entry entry)
    {
        int result;

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_DATE, entry.getDate());
        values.put(KEY_WEIGHT_METRIC,entry.getWeightMetric());
        values.put(KEY_WEIGHT,entry.getWeight());
        values.put(KEY_BODY_FAT,entry.getBodyFat());
        values.put(KEY_WATER,entry.getBone());
        values.put(KEY_BONE,entry.getBone());
        values.put(KEY_BMI,entry.getBmi());

        result = db.update(TABLE_NAME,values,KEY_ID + " -?", new String[]{String.valueOf(entry.getId())});

        db.close();

        return result;
    }

    public void deleteRecord(Entry entry)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,KEY_ID + " -?",new String[]{String.valueOf(entry.getId())});
        db.close();
    }


    public List<Entry> getAllRecords()
    {
        List<Entry> listEntries = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                Entry entry = new Entry();
                entry.setId(cursor.getInt(0));
                entry.setDate(cursor.getInt(0));

                listEntries.add(entry);
            }
            while (cursor.moveToNext());
        }
        return listEntries;
    }


    public String dbToString() {
        String dbSting = "Entries: ";
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "SELECT count(*) FROM " + TABLE_NAME;

        //Cur point to a location in your results
        Cursor c = db.rawQuery(qry,null);
        c.moveToFirst();

        dbSting += c.getString(0);

        db.close();
        return dbSting;
    }
}