package com.robson.meucontador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class BillDao {

    private Connection connection;
    private SQLiteDatabase db;

    public BillDao(Context context) {
        connection = new Connection(context);
        db = connection.getWritableDatabase();
    }

    public long insert(Bill bill) {
        ContentValues values = new ContentValues();
        // values.put("id", bill.getId());
        values.put("title", bill.getTitle());
        values.put("type", bill.getType());
        values.put("price", bill.getPrice());
        return db.insert("bill", null, values);
    }

    public List<Bill> findAll() {
        List<Bill> bills = new ArrayList<>();
        // Cursor cursor = db.query("bill", new String[]{"id", "title", "type", "price"},
        //        null, null, null, null, null);
        Cursor cursor = db.query("bill", new String[]{"id", "title", "type", "price"},
                null, null, null, null, null);

        while(cursor.moveToNext()) {
            Bill bill = new Bill();
            // bill.setId(cursor.getLong(0));
            bill.setTitle(cursor.getString(1));
            bill.setType(cursor.getString(2));
            bill.setPrice(cursor.getDouble(3));
            bills.add(bill);
        }

        return bills;
    }
}
