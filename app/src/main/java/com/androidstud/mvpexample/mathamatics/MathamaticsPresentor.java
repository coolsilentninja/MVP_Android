package com.androidstud.mvpexample.mathamatics;

import com.androidstud.mvpexample.login.LoginContract;

/**
 * Created by ninja on 10/6/17.
 *
 * http://androidstud.com
 */
public class MathamaticsPresentor implements MathamaticsContract.Presentor {

    private MathamaticsContract.View mMathView;

    // no need
    // private LoginContract.Iteractor mLoginIntractor;

    public MathamaticsPresentor(MathamaticsContract.View mathView) {

        mMathView = mathView;


    }

    @Override
    public void add(int a, int b) {


        int value = a+b;

        mMathView.additionResult(value);
    }

    @Override
    public void subtract(int a, int b) {
        int value = a-b;
        mMathView.subtractResult(value);
    }

    @Override
    public void multiply(int a, int b) {
        int value = a*b;
        mMathView.multiplyResult(value);
    }

    @Override
    public void divide(int a, int b) {

        int value = a/b;
        mMathView.divideResult(value);
    }
}
