package com.example.c0754254_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText username;
    EditText password;
    Button  login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().trim().length() == 0){
                    username.setError("Field is empty");
                   showAlert(Login.this,"ERROR","Enter Username");
                }
                else if(password.getText().toString().trim().length() == 0){
                    password.setError("Field is empty");
                    showAlert(Login.this,"Error","Enter Password");
                }
                else{
                    if(username.getText().toString().trim().equals("admin") && password.getText().toString().trim().equals("admin")){
                        startActivity(new Intent(Login.this,HomeScreen.class));
                    }
                    else{
                        showAlert(Login.this,"Invalid Credentials","The username or password you entered is incorrect. ");
                    }
                }
            }
        });

    }
    private void init(){
        username = findViewById(R.id.txtEmail);
        password = findViewById(R.id.txtPassword);
        login = findViewById(R.id.btnLogin);
    }
    private void showAlert(Context context,String title,String message){
        android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(
                context);
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog
                        dialog.cancel();
                    }
                });
        alertDialog.show();
    }
}








