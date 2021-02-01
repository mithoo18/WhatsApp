package com.example.whatsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.whatsapp.databinding.ActivitySignInBinding;
import com.example.whatsapp.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {

    @NonNull ActivitySignInBinding binding;
    ProgressDialog progressDialog;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //HIDE TOOLBAR
        getSupportActionBar().hide();

        //BINDING VIEW - No Need To Define Again And Again From Layout TO A Main Acivity
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Firebase
        auth = FirebaseAuth.getInstance();

        //PROGRESS
        progressDialog = new ProgressDialog(SignIn.this);
        progressDialog.setTitle("Login");
        progressDialog.setMessage("Login To Your Account");

        //ONClICK
        binding.btnSignIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                progressDialog.show();
                auth.signInWithEmailAndPassword(binding.etEmail.getText().toString(),binding.etPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                    progressDialog.dismiss();
                    if(task.isSuccessful()) {
                        Intent intent = new Intent(SignIn.this,MainActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(SignIn.this, "Problem In SignIn", Toast.LENGTH_SHORT).show();
                    }
                    }
                });
            }
        });
        binding.signUpView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignIn.this,SignUpActivity.class);
                startActivity(intent);
            }
        });


        //LOGIC FOR SAVE LOGIN DETAIL
        if(auth.getCurrentUser()!=null)
        {
            Intent intent = new Intent(SignIn.this,MainActivity.class);
            startActivity(intent);
        }
    }
}