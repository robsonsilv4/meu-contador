package com.robson.meucontador;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddBillActivity extends AppCompatActivity {

    private EditText title;
    private EditText type;
    private EditText price;

    private static final String DATABASE_NAME = "Bills.db";
    private BillDatabase billDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bill);

        billDatabase = Room.databaseBuilder(getApplicationContext(), BillDatabase.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();

        title = findViewById(R.id.edit_text_title);
        type = findViewById(R.id.edit_text_type);
        price = findViewById(R.id.edit_text_price);
    }

    public void save(View view) {
        new Thread((new Runnable() {
            @Override
            public void run() {
                Bill bill = new Bill();
                bill.setId(null);
                bill.setTitle(title.getText().toString());
                bill.setType(type.getText().toString());
                bill.setPrice(Double.parseDouble(price.getText().toString()));
                billDatabase.billDao().insert(bill);
            }
        })).start();

        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
        Toast.makeText(this, "Despesa adicionada com sucesso!", Toast.LENGTH_SHORT).show();
    }
}
