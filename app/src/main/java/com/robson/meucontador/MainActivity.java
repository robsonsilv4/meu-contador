package com.robson.meucontador;

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
                Toast.makeText(this, "Opções de Despesas", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(this, "Opções de Usuários", Toast.LENGTH_SHORT).show();
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
