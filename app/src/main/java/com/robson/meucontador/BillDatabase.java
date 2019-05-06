package com.robson.meucontador;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Bill.class}, version = 1, exportSchema = false)
public abstract class BillDatabase extends RoomDatabase {

    public abstract BillDao billDao();
}
