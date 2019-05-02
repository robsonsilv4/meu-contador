package com.robson.meucontador;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class UserDao {

    private Connection connection;
    private SQLiteDatabase db;

    public UserDao(Context context) {
        connection = new Connection(context);
        db = connection.getWritableDatabase();
    }

    public long insert(User user) {
        ContentValues values = new ContentValues();
        values.put("name", user.getName());
        values.put("username", user.getUsername());
        values.put("phone", user.getPhone());
        values.put("password", user.getPassword());
        return db.insert("user", null, values);
    }
}
