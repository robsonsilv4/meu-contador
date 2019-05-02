package com.robson.meucontador;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Connection extends SQLiteOpenHelper {

    public static final String name = "database.db";
    public static final int version = 1;

    public Connection(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(id integer primary key autoincrement, name varchar(255)," +
                "username varchar(100), phone varhcar(15), password varchar(255))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
