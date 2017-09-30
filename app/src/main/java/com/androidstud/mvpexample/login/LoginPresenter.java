package com.androidstud.mvpexample.login;

import android.app.Activity;

/**
 *
 * Created by ninja on 17/5/17.
 *
 * http://androidstud.com
 */
public class LoginPresenter implements LoginContract.Presenter, LoginContract.OnLoginListener {


    private LoginContract.View mLoginView;
    private LoginContract.Iteractor mLoginIntractor;

    public LoginPresenter(LoginContract.View loginView) {

        mLoginView = loginView;
        mLoginIntractor = new LoginInterctor(this);

    }

    /**
     * Implementation of method user for handling login action button functionality
     *
     * @param activity
     * @param userName
     * @param password
     */
    @Override
    public void Login(Activity activity, String userName, String password) {

        // checking for valid credentials
        // could be from webservice or local
        mLoginIntractor.performLogin(userName, password);
    }

    @Override
    public void onSuccess(LoginModel loginToken) {

        mLoginView.onLoginSuccess(loginToken);
    }

    @Override
    public void onFailure(LoginModel message) {

        mLoginView.onLoginFailure(message);
    }
}
