package com.androidstud.mvpexample.login;

import android.app.Activity;

/**
 * Login contract class
 *
 * Created by ninja on 17/5/17
 *
 * http://androidstud.com.
 */
public class LoginContract {

   public interface View {

        void onLoginSuccess(LoginModel loginModel);

        void onLoginFailure(LoginModel failureModel);

    }

   public interface Presenter {

        void Login(Activity activity, String userName, String Password);
    }


    public interface Iteractor {

        void performLogin(String userName, String Password);
    }

    interface OnLoginListener {
        void onSuccess(LoginModel loginToken);

        void onFailure(LoginModel message);
    }

}
