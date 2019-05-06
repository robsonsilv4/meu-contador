package com.robson.meucontador;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

public interface BillDao {

    @Insert
    void insertBill(Bill bill);

    @Insert
    void insertBills(List<Bill> bills);

    @Update
    void updateBill(Bill bill);

    @Delete
    void deleteBill(Bill bill);

    @Query("SELECT * FROM Bill WHERE id = :id")
    Bill getBillById(Long id);
}
