package com.robson.meucontador;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ListUsersActivity extends AppCompatActivity {

    private static final String DATABASE_NAME = "Bills.db";
    private UserDatabase userDatabase;

    private ListView listView;
    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);
        getSupportActionBar().setTitle("Lista de Usuários");

        userDatabase = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();

        listView = findViewById(R.id.users_list);

        new Thread((new Runnable() {
            @Override
            public void run() {
                users = userDatabase.userDao().findAll();
            }
        })).start();

        ArrayAdapter<User> adapter = new ArrayAdapter<User>(this, android.R.layout.simple_list_item_1, users);
        listView.setAdapter(adapter);
    }
}
