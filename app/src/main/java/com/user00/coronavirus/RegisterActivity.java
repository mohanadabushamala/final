package com.user00.coronavirus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        auth = FirebaseAuth.getInstance();


        Button register = findViewById(R.id.register_btn);

        final EditText emailEt = findViewById(R.id.register_email);
        final EditText passwordEt = findViewById(R.id.register_password);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = Objects.requireNonNull(emailEt.getText()).toString();
                String password = Objects.requireNonNull(passwordEt.getText()).toString();

                if (!email.isEmpty() && !password.isEmpty()) {

                    Task<AuthResult> task = auth.createUserWithEmailAndPassword(email, password);
                    task.addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);

                            }else{
                                Toast.makeText(RegisterActivity.this, "Register Failed, Try Again", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }else {
                    Toast.makeText(RegisterActivity.this, "Enter Name and Password, Please.", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }



}
