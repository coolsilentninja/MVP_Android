package com.androidstud.mvpexample.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidstud.mvpexample.R;
import com.androidstud.mvpexample.mathamatics.MathamaticsContract;
import com.androidstud.mvpexample.mathamatics.MathamaticsPresentor;

/**
 * Activity class (view) for showing mathamatics caliberation
 *
 */

public class MathamaticsActivity extends AppCompatActivity implements MathamaticsContract.View, View.OnClickListener{

    Button add, subtract, multiply, divide;

    EditText paramA, paramB;
    TextView result;
    MathamaticsPresentor mathamaticsPresentor = new MathamaticsPresentor(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathamatics);

        paramA = (EditText) findViewById(R.id.paramA);
        paramB = (EditText) findViewById(R.id.paramB);

        add = (Button) findViewById(R.id.add);
        subtract = (Button) findViewById(R.id.subtract);
        multiply = (Button) findViewById(R.id.multiply);
        divide = (Button) findViewById(R.id.divide);

        result = (TextView) findViewById(R.id.result);

        add.setOnClickListener(this);
        subtract.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();
        int paramAInt, paramBInt;

        if(!paramA.getText().toString().trim().isEmpty()) {
            paramAInt = Integer.parseInt(paramA.getText().toString());
        } else {
            Toast.makeText(MathamaticsActivity.this, "Param A missing", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!paramB.getText().toString().trim().isEmpty()) {
            paramBInt = Integer.parseInt(paramB.getText().toString());
        } else {
            Toast.makeText(MathamaticsActivity.this, "Param B missing", Toast.LENGTH_SHORT).show();
            return;
        }

        switch (id) {

            case R.id.add:
                mathamaticsPresentor.add(paramAInt, paramBInt);
                break;

            case R.id.subtract:
                mathamaticsPresentor.subtract(paramAInt, paramBInt);
                break;

            case R.id.multiply:
                mathamaticsPresentor.multiply(paramAInt, paramBInt);
                break;

            case R.id.divide:
                mathamaticsPresentor.divide(paramAInt, paramBInt);
                break;
        }

    }

    @Override
    public void additionResult(int resultValue) {
        result.setText("Addded result: " + resultValue);
    }

    @Override
    public void subtractResult(int resultValue) {
        result.setText("Subtract result: " + resultValue);
    }

    @Override
    public void multiplyResult(int resultValue) {
        result.setText("Multiply result: " + resultValue);
    }

    @Override
    public void divideResult(int resultValue) {
        result.setText("Divide result: " + resultValue);
    }
}
