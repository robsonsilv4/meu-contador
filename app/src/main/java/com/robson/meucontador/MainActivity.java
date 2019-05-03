package com.robson.meucontador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private BillDao dao;
    private List<Bill> bills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Lista de Despesas");

        listView = findViewById(R.id.bills_list);
        dao = new BillDao(this);

        Bill b1 = new Bill("Aluguel", "Fixa", 450.00);
        Bill b2 = new Bill("Energia", "Fixa", 90.00);
        Bill b3 = new Bill("Água", "Fixa", 25.00);
        Bill b4 = new Bill("Internet", "Fixa", 86.00);
        Bill b5 = new Bill("Gás", "Fixa", 75.00);

        dao.insert(b1);
        dao.insert(b2);
        dao.insert(b3);
        dao.insert(b4);
        dao.insert(b5);

        bills = dao.findAll();

        ArrayAdapter<Bill> adapter = new ArrayAdapter<Bill>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
    }
}
