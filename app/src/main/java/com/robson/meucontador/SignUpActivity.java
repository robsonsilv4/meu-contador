package com.robson.meucontador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private EditText name;
    private EditText username;
    private EditText phone;
    private EditText password1;
    private EditText password2;

    private UserDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().setTitle("Cadastro de Usuários");

        name = findViewById(R.id.edit_text_name);
        username = findViewById(R.id.edit_text_username);
        phone = findViewById(R.id.edit_text_phone);
        password1 = findViewById(R.id.edit_text_password1);
        password2 = findViewById(R.id.edit_text_password2);

        dao = new UserDao(this);
    }

    public void save(View view) {
        User user = new User();
        user.setName(name.getText().toString());
        user.setName(username.getText().toString());
        user.setName(phone.getText().toString());

        if (password1.getText().toString().equals(password2.getText().toString())) {
            Toast.makeText(this, "As senha não coincidem!", Toast.LENGTH_SHORT).show();
        }

        user.setPassword(password1.getText().toString());

        dao.insert(user);
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));

        Toast.makeText(this, "Usuário criado com sucesso!", Toast.LENGTH_SHORT).show();
    }
}
