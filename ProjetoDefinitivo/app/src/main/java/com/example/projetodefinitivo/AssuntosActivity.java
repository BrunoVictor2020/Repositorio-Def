package com.example.projetodefinitivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AssuntosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assuntos);
    }
    public void exercicio1(View view){
        startActivity(new Intent(AssuntosActivity.this, Exercicio1Activity.class));
    }
}
