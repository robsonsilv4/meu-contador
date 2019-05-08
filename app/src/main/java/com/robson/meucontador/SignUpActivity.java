package com.robson.meucontador;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private static final String DATABASE_NAME = "Users.db";
    private UserDatabase userDatabase;

    private EditText username;
    private EditText name;
    private EditText phone;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().setTitle("Cadastro de Usuários");

        userDatabase = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();

        name = findViewById(R.id.edit_text_name);
        username = findViewById(R.id.edit_text_username);
        phone = findViewById(R.id.edit_text_phone);
        password = findViewById(R.id.edit_text_password1);
    }

    public void save(View view) {

        new Thread((new Runnable() {
            @Override
            public void run() {
                User user = new User();
                user.setId(null);
                user.setUsername(username.getText().toString());
                user.setName(name.getText().toString());
                user.setPhone(phone.getText().toString());
                user.setPassword(password.getText().toString());
                userDatabase.userDao().insert(user);
            }
        })).start();
        
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
        Toast.makeText(this, "Usuário criado com sucesso!", Toast.LENGTH_SHORT).show();
    }
}
