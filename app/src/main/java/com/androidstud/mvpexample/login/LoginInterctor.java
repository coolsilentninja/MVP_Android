package com.androidstud.mvpexample.login;

import android.os.Handler;

import java.util.Random;

/**
 * Login intractor class
 *
 * Created by ninja on 17/5/17.
 *
 * http://androidstud.com
 */
public class LoginInterctor implements LoginContract.Iteractor {

    LoginContract.OnLoginListener mOnLoginListener;

    LoginInterctor(LoginContract.OnLoginListener onLoginListener) {

        mOnLoginListener = onLoginListener;
    }

    /**
     * method called for handling login
     *
     * could be used for calling webservice or db query for checking valid credentials
     * and sending valid token
     *
     * currently waits for 3 seconds and randonly sends whether it is a successful login or not
     *
     * @param userName
     * @param Password
     */

    @Override
    public void performLogin(String userName, String Password) {

        new
                Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Random random = new Random();

                if(random.nextBoolean()) {

                    LoginModel loginModel = new LoginModel();
                    loginModel.errorString = "";
                    loginModel.responseStatus = 200;
                    loginModel.sessionToken = String.valueOf(System.currentTimeMillis());
                    loginModel.userId = random.nextInt();

                    mOnLoginListener.onSuccess(loginModel);
                } else {

                    LoginModel loginModel = new LoginModel();
                    loginModel.errorString = "Login not successful";
                    loginModel.responseStatus = 400;

                    mOnLoginListener.onFailure(loginModel);
                }
            }
        }, 3000);


    }
}
