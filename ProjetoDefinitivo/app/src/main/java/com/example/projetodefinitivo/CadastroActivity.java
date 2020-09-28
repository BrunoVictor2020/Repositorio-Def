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

public class CadastroActivity extends AppCompatActivity {
    public FirebaseAuth mAuth;
    ImageButton btCadastrar;
    EditText tilName,tilEmail,tilPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        mAuth = FirebaseAuth.getInstance();
        btCadastrar=findViewById(R.id.btCadastrar);
        tilEmail=findViewById(R.id.tilEmail);
        tilName=findViewById(R.id.tilName);
        tilPassword=findViewById(R.id.tilPassword);

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doCadastro();
            }
        });
    }
    public void doCadastro(){
        String email, password;
        email=tilEmail.getText().toString();
        password=tilPassword.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(CadastroActivity.this,"Cadastro realizado com sucessso!",Toast.LENGTH_SHORT).show();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(CadastroActivity.this, "Erro ao realizar cadastro.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }
    public void updateUI(FirebaseUser firebaseUser){
        String msg="Voltando para a tela de login";
        Toast.makeText(CadastroActivity.this,msg,Toast.LENGTH_SHORT).show();
        finish();
        startActivity(new Intent(CadastroActivity.this,LoginActivity.class));
    }
}
