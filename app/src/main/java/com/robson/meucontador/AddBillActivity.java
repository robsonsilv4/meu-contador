package com.robson.meucontador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddBillActivity extends AppCompatActivity {

    private EditText title;
    private EditText type;
    private EditText price;
    private BillDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bill);

        title = findViewById(R.id.edit_text_title);
        type = findViewById(R.id.edit_text_type);
        price = findViewById(R.id.edit_text_price);

        dao = new BillDao(this);
    }

    public void save(View view) {
        Bill bill = new Bill();
        bill.setTitle(title.getText().toString());
        bill.setType(type.getText().toString());
        // TODO: Converter para Double
        // bill.setPrice(price.getText().toString());

        dao.insert(bill);
        Toast.makeText(this, "Despesa adicionada com sucesso!", Toast.LENGTH_SHORT).show();
    }
}
