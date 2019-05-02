package com.robson.meucontador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
        bills = dao.findAll();

        ArrayAdapter<Bill> adapter = new ArrayAdapter<Bill>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
    }
}
