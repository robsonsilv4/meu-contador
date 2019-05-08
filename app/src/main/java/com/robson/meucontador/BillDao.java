package com.robson.meucontador;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface BillDao {

    @Insert
    void insert(Bill bill);

    @Insert
    void insert(List<Bill> bills);

    @Update
    void update(Bill bill);

    @Delete
    void delete(Bill bill);

    @Query("SELECT * FROM bill")
    List<Bill> findAll();

    // @Query("SELECT * FROM Bill WHERE id = :id")
    // Bill getBillById(Long id);
}
