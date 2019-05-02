package com.robson.meucontador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

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

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        Cursor cursor = db.query("user", new String[]{"id", "name", "username", "phone"},
                null, null, null, null, null);

        while(cursor.moveToNext()) {
            User user = new User();
            user.setId(cursor.getLong(0));
            user.setName(cursor.getString(1));
            user.setUsername(cursor.getString(2));
            user.setPhone(cursor.getString(3));
            users.add(user);
        }

        return users;
    }
}
