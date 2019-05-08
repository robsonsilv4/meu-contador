package com.robson.meucontador;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String DATABASE_NAME = "Bills.db";
    private BillDatabase billDatabase;

    private ListView listView;
    private List<Bill> bills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Lista de Despesas");

        billDatabase = Room.databaseBuilder(getApplicationContext(), BillDatabase.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();

        listView = findViewById(R.id.bills_list);

        bills = new ArrayList<>();
        new Thread((new Runnable() {
            @Override
            public void run() {
                bills = billDatabase.billDao().findAll();
            }
        })).start();

        ArrayAdapter<Bill> adapter = new ArrayAdapter<Bill>(this, android.R.layout.simple_list_item_1, bills);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bills_option:
                return true;

            case R.id.add_bill_option:
                startActivity(new Intent(getApplicationContext(), AddBillActivity.class));
                Toast.makeText(this, "Adicionar Despesas", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.list_bills_option:
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                Toast.makeText(this, "Listar Despesas", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.users_option:
                return true;

            case R.id.add_user_option:
                // TODO: Criar Activity para adição/convite de usuários
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
                Toast.makeText(this, "Adicionar Usuários", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.list_users_option:
                startActivity(new Intent(getApplicationContext(), ListUsersActivity.class));
                Toast.makeText(this, "Listar Usuário", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public void btnAddBillAcitivity(View view) {
        startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
    }
}
