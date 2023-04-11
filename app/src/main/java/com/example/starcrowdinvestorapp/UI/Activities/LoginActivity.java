package com.example.starcrowdinvestorapp.UI.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.starcrowdinvestorapp.DB.RetrofitClient;
import com.example.starcrowdinvestorapp.DB.SharedPrefManager;
import com.example.starcrowdinvestorapp.DB.UserResponse;
import com.example.starcrowdinvestorapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText editTextUserLogin;
    EditText editTextPassword;
    Button buttonLogin;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_StarcrowdInvestorApp);
        setContentView(R.layout.activity_login_user);


        editTextUserLogin = findViewById(R.id.usernameEditText);
        editTextPassword = findViewById(R.id.passwordEditText);
        buttonLogin = findViewById(R.id.buttonLogin);
        progressBar = findViewById(R.id.userProgressLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });
    }

    public void userLogin(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
//        String username = editTextUserLogin.getText().toString().trim();
//        String password = editTextPassword.getText().toString().trim();
//        if (username.isEmpty()) {
//            editTextUserLogin.setError("Username is required");
//            editTextUserLogin.requestFocus();
//            return;
//        }
//
//        if (password.isEmpty()) {
//            editTextPassword.setError("Password is required");
//            editTextPassword.requestFocus();
//            return;
//        }
//
//        Call<UserResponse> call = RetrofitClient
//                .getInstance()
//                .getApi()
//                .userLogin(username, password);
//        call.enqueue(new Callback<UserResponse>() {
//            @Override
//            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
//                UserResponse loginResponse = response.body();
//                if(!loginResponse.isError()) {
//                    SharedPrefManager.getInstance(LoginActivity.this).saveUser(loginResponse.getUser());
//
//                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                    startActivity(intent);
//                } else {
//                    Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<UserResponse> call, Throwable t) {
//                Toast.makeText(LoginActivity.this, "Failed to login, try again", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

}