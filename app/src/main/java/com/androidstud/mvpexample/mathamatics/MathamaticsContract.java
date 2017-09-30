package com.androidstud.mvpexample.mathamatics;

import android.view.View;

/**
 * Created by karan on 10/6/17.
 */
public class MathamaticsContract {

    public interface View {

        public void additionResult(int result);
        public void subtractResult(int result);
        public void multiplyResult(int result);
        public void divideResult(int result);
    }

    public interface Presentor {

        public void add(int a, int b);
        public void subtract(int a, int b);
        public void multiply(int a, int b);
        public void divide(int a, int b);

    }


}
