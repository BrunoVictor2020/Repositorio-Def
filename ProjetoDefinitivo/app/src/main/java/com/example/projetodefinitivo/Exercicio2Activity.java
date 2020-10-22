package com.example.projetodefinitivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class Exercicio2Activity extends AppCompatActivity {
    public RadioButton certo2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio2);
        certo2=findViewById(R.id.certo2);
    }
    public void exercicio1(View view){
        startActivity(new Intent(Exercicio2Activity.this, Exercicio1Activity.class));
    }
    public void menu(View view){
        startActivity(new Intent(Exercicio2Activity.this, AssuntosActivity.class));
    }
    public void responder(View view){
        if(certo2.isChecked()){
            Toast.makeText(getApplicationContext(),"Certa resposta!!!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(),"Resposta Incorreta! Tente novamente.",Toast.LENGTH_LONG).show();
        }
    }
}
