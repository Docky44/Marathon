package com.example.marathon;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class JeuDataSource {

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = {MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_JOUEUR1,
            MySQLiteHelper.COLUMN_JOUEUR2,
            MySQLiteHelper.COLUMN_DISTANCE1,
            MySQLiteHelper.COLUMN_DISTANCE2,
            MySQLiteHelper.COLUMN_SCORE1,
            MySQLiteHelper.COLUMN_SCORE2,
            MySQLiteHelper.COLUMN_TEMPS,
            MySQLiteHelper.COLUMN_DATE};

    public JeuDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Jeu createJeu(String JOUEUR1, String JOUEUR2, int DISTANCE1, int DISTANCE2, int SCORE1, int SCORE2, String TEMPS, String Date) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_JOUEUR1, JOUEUR1);
        values.put(MySQLiteHelper.COLUMN_JOUEUR2, JOUEUR2);
        values.put(MySQLiteHelper.COLUMN_DISTANCE1, DISTANCE1);
        values.put(MySQLiteHelper.COLUMN_DISTANCE2, DISTANCE2);
        values.put(MySQLiteHelper.COLUMN_SCORE1, SCORE1);
        values.put(MySQLiteHelper.COLUMN_SCORE2, SCORE2);
        values.put(MySQLiteHelper.COLUMN_TEMPS, TEMPS);
        values.put(MySQLiteHelper.COLUMN_DATE, Date);

        long insertId = database.insert(MySQLiteHelper.TABLE_NAME, null,
                values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_NAME,
                allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Jeu newJeu = cursorToJeu(cursor);
        cursor.close();
        return newJeu;
    }

    public void updateJeu(long id, String JOUEUR1, String JOUEUR2, int DISTANCE1, int DISTANCE2, int SCORE1, int SCORE2, String TEMPS, String Date) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_ID, id);
        values.put(MySQLiteHelper.COLUMN_JOUEUR1, JOUEUR1);
        values.put(MySQLiteHelper.COLUMN_JOUEUR2, JOUEUR2);
        values.put(MySQLiteHelper.COLUMN_DISTANCE1, DISTANCE1);
        values.put(MySQLiteHelper.COLUMN_DISTANCE2, DISTANCE2);
        values.put(MySQLiteHelper.COLUMN_SCORE1, SCORE1);
        values.put(MySQLiteHelper.COLUMN_SCORE2, SCORE2);
        values.put(MySQLiteHelper.COLUMN_TEMPS, TEMPS);
        values.put(MySQLiteHelper.COLUMN_DATE, Date);

        database.update(MySQLiteHelper.TABLE_NAME, values, "_id = ?", new String[]{String.valueOf(id)});
    }

    public List<Jeu> getAllJeu() {
        List<Jeu> jeux = new ArrayList<Jeu>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_NAME,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Jeu jeu = cursorToJeu(cursor);
            jeux.add(jeu);
            cursor.moveToNext();
        }

        cursor.close();
        return jeux;
    }

    private Jeu cursorToJeu(Cursor cursor) {
        Jeu jeux = new Jeu();
        jeux.setId(cursor.getLong(0));
        jeux.setJOUEUR1(cursor.getString(1));
        jeux.setJOUEUR2(cursor.getString(2));
        jeux.setDISTANCE1(cursor.getInt(3));
        jeux.setDISTANCE2(cursor.getInt(4));
        jeux.setSCORE1(cursor.getInt(5));
        jeux.setSCORE2(cursor.getInt(6));
        jeux.setTEMPS(cursor.getString(7));
        jeux.setDATE(cursor.getString(8));
        return jeux;
    }
}