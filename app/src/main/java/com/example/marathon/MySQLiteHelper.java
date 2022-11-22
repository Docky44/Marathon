package com.example.marathon; // A changer par votre package

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
    public static final String COLUMN_LANCE = "lance";
    public static final String COLUMN_TEMPS = "temps";
    public static final String COLUMN_DATE = "date";
    // A vous de définir les autres colonnes...

    private static final String DATABASE_NAME = "jeu.db"; // Le plus logique est de donner le même nom que votre appli
    private static final int DATABASE_VERSION = 1;

    // Commande sql pour la création de la base de données
    private static final String DATABASE_CREATE = "create table "
            + TABLE_NAME + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_JOUEUR1 + COLUMN_JOUEUR2 + COLUMN_LANCE + COLUMN_TEMPS + COLUMN_DATE
            + " text not null);";// A vous de modifier la requête en ajoutant les autres colonnes


// C'est terminé pour cette classe, les méthodes ci-dessous sont des méthodes de base

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