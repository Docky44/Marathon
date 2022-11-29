package com.example.marathon;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.time.OffsetDateTime;

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "jeu";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_JOUEUR1 = "joueur1";
    public static final String COLUMN_JOUEUR2 = "joueur2";
    public static final String COLUMN_DISTANCE1 = "distance1";
    public static final String COLUMN_DISTANCE2 = "distance2";
    public static final String COLUMN_SCORE1 = "score1";
    public static final String COLUMN_SCORE2 = "score2";
    public static final String COLUMN_TEMPS = "temps";
    public static final String COLUMN_DATE = "date";
    // A vous de définir les autres colonnes...

    private static final String DATABASE_NAME = "jeu.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table "
            + TABLE_NAME + "(" + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_JOUEUR1 + " text not null, "
            + COLUMN_JOUEUR2 + " text not null, "
            + COLUMN_DISTANCE1 + " integer not null, "
            + COLUMN_DISTANCE2 + " integer not null, "
            + COLUMN_SCORE1 + " integer not null, "
            + COLUMN_SCORE2 + " integer not null, "
            + COLUMN_DATE + " datetime not null, "
            + COLUMN_TEMPS + " time);";


    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "MàJ de la version " + oldVersion + " vers "
                        + newVersion + ", les vieilles données ont été supprimées");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}