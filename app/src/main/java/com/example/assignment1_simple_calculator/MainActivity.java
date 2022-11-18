package com.example.assignment1_simple_calculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView resultText;
    Button n0;
    Button n1;
    Button n2;
    Button n3;
    Button n4;
    Button n5;
    Button n6;
    Button n7;
    Button n8;
    Button n9;
    Button clearBut;
    Button equalBut;
    Button addBut;
    Button subBut;
    Button timBut;
    Button divBut;
    Button advanceBut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Calculator App", "Activity Created");

        resultText = findViewById(R.id.showResText);
        n0 = findViewById(R.id.num0);
        n1 = findViewById(R.id.num1);
        n2 = findViewById(R.id.num2);
        n3 = findViewById(R.id.num3);
        n4 = findViewById(R.id.num4);
        n5 = findViewById(R.id.num5);
        n6 = findViewById(R.id.num6);
        n7 = findViewById(R.id.num7);
        n8 = findViewById(R.id.num8);
        n9 = findViewById(R.id.num9);
        clearBut = findViewById(R.id.clearButton);
        equalBut = findViewById(R.id.equalButton);
        addBut = findViewById(R.id.addButton);
        subBut = findViewById(R.id.subButton);
        timBut = findViewById(R.id.timButton);
        divBut = findViewById(R.id.divButton);
        advanceBut = findViewById(R.id.toAdvanceButton);

        n0.setOnClickListener(this);
        n1.setOnClickListener(this);
        n2.setOnClickListener(this);
        n3.setOnClickListener(this);
        n4.setOnClickListener(this);
        n5.setOnClickListener(this);
        n6.setOnClickListener(this);
        n7.setOnClickListener(this);
        n8.setOnClickListener(this);
        n9.setOnClickListener(this);
        clearBut.setOnClickListener(this);
        equalBut.setOnClickListener(this);
        addBut.setOnClickListener(this);
        subBut.setOnClickListener(this);
        timBut.setOnClickListener(this);
        divBut.setOnClickListener(this);
        advanceBut.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        String symbol;
        switch (view.getId()) {
            case R.id.clearButton:
                CalculatorClass.history = "";
                resultText.setText(CalculatorClass.history);
                CalculatorClass.historyArrayList.clear();
                break;
            case R.id.toAdvanceButton:
                Intent firstIntent = new Intent(MainActivity.this, AdvanceVersion.class);
                startActivity(firstIntent);
                break;
            default:
                //get symbol and validate it
                symbol = ((Button) view).getText().toString();
                if (CalculatorClass.isNumber(symbol)) {
                    CalculatorClass.push(symbol);
                    resultText.setText(CalculatorClass.history);
                } else {
                    if (CalculatorClass.history.isEmpty()) {
                        Toast.makeText(MainActivity.this, "First symbol have to be a number", Toast.LENGTH_SHORT).show();
                    } else {
                        String previousSymbol = String.valueOf(CalculatorClass.history.charAt(CalculatorClass.history.length() - 1));
                        if (CalculatorClass.isOperator(previousSymbol)) {
                            Toast.makeText(MainActivity.this, "You cannot use two operators in a row, enter a number", Toast.LENGTH_SHORT).show();
                        } else {
                            CalculatorClass.push(symbol);
                            if (symbol.equals("=")) {
                                if (CalculatorClass.historyArrayList.size() < 3) {
                                    Toast.makeText(MainActivity.this, "You cannot to count it, enter correct data", Toast.LENGTH_SHORT).show();
                                    CalculatorClass.historyArrayList.clear();
                                    CalculatorClass.history = CalculatorClass.history.substring(0, CalculatorClass.history.length() - 1);
                                } else {
                                    CalculatorClass.calculate();
                                    resultText.setText(CalculatorClass.history);
                                    CalculatorClass.history = "";
                                }
                            } else {
                                resultText.setText(CalculatorClass.history);
                            }
                        }
                    }
                }
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Calculator App", "Activity Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Calculator App", "Activity Resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Calculator App", "Activity Paused");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Calculator App", "Activity Restarted");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Calculator App", "Activity Destroyed");
    }


}