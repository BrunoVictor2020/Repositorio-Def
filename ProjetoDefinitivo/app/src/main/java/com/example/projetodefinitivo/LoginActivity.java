package com.example.projetodefinitivo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText tilEmail, tilPassword;
    ImageButton btLogin,btCadastrarse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        tilEmail=findViewById(R.id.tilEmail);
        tilPassword=findViewById(R.id.tilPassword);
        btLogin=findViewById(R.id.btLogin);
        btCadastrarse=findViewById(R.id.btCadastrarse);

        btCadastrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,CadastroActivity.class));
            }
        });
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });
    }
    private void doLogin(){
        String msg="Iniciando o login.";
        Toast.makeText(LoginActivity.this,msg,Toast.LENGTH_SHORT).show();
        String email=tilEmail.getText().toString();
        String password=tilPassword.getText().toString();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LoginActivity.this, "Falha ao realizar o login", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void updateUI (FirebaseUser firebaseUser){
        String msg="Iniciando Tela principal do app.";
        Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
        finish();
        startActivity(new Intent(LoginActivity.this, AssuntosActivity.class));
    }
}
