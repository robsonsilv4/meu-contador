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

        listView = findViewById(R.id.users_list);
        dao = new UserDao(this);
        users = dao.findAll();

        ArrayAdapter<User> adapter = new ArrayAdapter<User>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
    }
}
