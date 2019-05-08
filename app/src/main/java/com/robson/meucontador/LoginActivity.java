package com.robson.meucontador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Entrar");
    }

    public void btnMainAcitivity(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

    public void btnSignupAcitivity(View view) {
        startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
        finish();
    }
}
