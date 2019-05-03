package com.robson.meucontador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ListUsersActivity extends AppCompatActivity {

    private ListView listView;
    private UserDao dao;
    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);
        getSupportActionBar().setTitle("Lista de Usuários");

        listView = findViewById(R.id.users_list);
        dao = new UserDao(this);

        User u1 = new User("Robson", "robson", "12345", "123");
        User u2 = new User("Gildard", "gil", "12345", "123");
        User u3 = new User("Gabriel", "gabriel", "12345", "123");
        User u4 = new User("Max", "max", "12345", "123");

        dao.insert(u1);
        dao.insert(u2);
        dao.insert(u3);
        dao.insert(u4);

        users = dao.findAll();

        ArrayAdapter<User> adapter = new ArrayAdapter<User>(this, android.R.layout.simple_list_item_1, users);
        listView.setAdapter(adapter);
    }
}
