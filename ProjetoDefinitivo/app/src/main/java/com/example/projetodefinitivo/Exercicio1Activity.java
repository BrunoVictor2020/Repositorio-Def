package com.example.projetodefinitivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class Exercicio1Activity extends AppCompatActivity {
    public RadioButton certo1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio1);
        certo1=findViewById(R.id.certo1);
    }
    public void menu(View view){
        startActivity(new Intent(Exercicio1Activity.this, AssuntosActivity.class));
    }
    public void exercicio2(View view){
        startActivity(new Intent(Exercicio1Activity.this, Exercicio2Activity.class));
    }
    public void responder(View view){
        if(certo1.isChecked()){
            Toast.makeText(getApplicationContext(),"Certa resposta!!!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(),"Resposta Incorreta! Tente novamente.",Toast.LENGTH_LONG).show();
        }
    }
}
