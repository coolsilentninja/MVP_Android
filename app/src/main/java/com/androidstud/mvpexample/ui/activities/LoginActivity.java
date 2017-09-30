package com.androidstud.mvpexample.ui.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidstud.mvpexample.R;
import com.androidstud.mvpexample.login.LoginContract;
import com.androidstud.mvpexample.login.LoginModel;
import com.androidstud.mvpexample.login.LoginPresenter;

/**
 * Login activity : view in our MVP pattern for login cycle
 *
 * Created by karan on 27/5/17.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginContract.View {

    private LoginPresenter mLoginPresenter;

    private EditText userName, password;
    private Button loginButton;
    ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_activity);

        // initializing views
        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);

        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);

        progressDialog = new ProgressDialog(this);

        // intializing presenter class
        mLoginPresenter = new LoginPresenter(LoginActivity.this);
    }

    @Override
    public void onClick(View view) {

        int id = view .getId();

        switch(id) {

            case R.id.loginButton:

                // on login button click

                // show progress dialog
                progressDialog.setMessage("Loging In");
                progressDialog.show();

                // send action (login button clicked) to presenter class
                mLoginPresenter.Login(LoginActivity.this,
                        userName.getText().toString(), password.getText().toString());
                break;
        }

    }

    @Override
    public void onLoginSuccess(LoginModel loginToken) {

        progressDialog.hide();
        Toast.makeText(LoginActivity.this, "Login done succesfully",
                Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(LoginActivity.this, MathamaticsActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void onLoginFailure(LoginModel failureMessage) {

        progressDialog.hide();
        Toast.makeText(LoginActivity.this, "Login failed",
                Toast.LENGTH_SHORT).show();
    }
}
