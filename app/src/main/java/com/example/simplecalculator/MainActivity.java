package com.example.simplecalculator;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button b0;
    private Button equal;
    private ImageButton mult;
    private ImageButton divide;
    private Button add;
    private Button sub;
    private ImageButton backSpace;
    private ImageButton light;
    private ImageButton night;
    private Button dot;
    private Button module;
    private Button clear;
    private TextView t1;
    private TextView t2;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQU = '=';
    private final char MODULUS = '%';
    private char ACTION;
    private double val1 = Double.NaN;;
    private double val2 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewSetup();
    }

    private void viewSetup() {
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        b0 = findViewById(R.id.button0);
        mult = findViewById(R.id.button_mult);
        divide = findViewById(R.id.button_div);
        add = findViewById(R.id.button_add);
        sub = findViewById(R.id.button_sub);
        module = findViewById(R.id.button_module);
        equal = findViewById(R.id.button_equal);
        dot = findViewById(R.id.button_dot);
        backSpace = findViewById(R.id.backspace);
        clear = findViewById(R.id.clear);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        light = findViewById(R.id.light);
        night= findViewById(R.id.night);
    }

    public void calculate(View clicked) {
        try{
        switch (clicked.getId()) {
            case R.id.button0:
                t1.setText(t1.getText().toString() + "0");
                break;
            case R.id.button1:
                t1.setText(t1.getText().toString() + "1");
                break;
            case R.id.button2:
                t1.setText(t1.getText().toString() + "2");
                break;
            case R.id.button3:
                t1.setText(t1.getText().toString() + "3");
                break;
            case R.id.button4:
                t1.setText(t1.getText().toString() + "4");
                break;
            case R.id.button5:
                t1.setText(t1.getText().toString() + "5");
                break;
            case R.id.button6:
                t1.setText(t1.getText().toString() + "6");
                break;
            case R.id.button7:
                t1.setText(t1.getText().toString() + "7");
                break;
            case R.id.button8:
                t1.setText(t1.getText().toString() + "8");
                break;
            case R.id.button9:
                t1.setText(t1.getText().toString() + "9");
                break;
            case R.id.clear:
                val1 = Double.NaN;
                val2 = Double.NaN;
                t1.setText("0");
                t2.setText("0");
                break;
            case R.id.backspace:
                CharSequence name = t1.getText().toString();
                t1.setText(name.subSequence(0, name.length() - 1));
                break;
            case R.id.button_equal:
                computeCalculation();
                t2.setText(t2.getText().toString() + String.valueOf(val2));
                t1.setText(String.valueOf(val1));
                val1 = Double.NaN;
                ACTION = '0';
                break;
            case R.id.button_add:
                computeCalculation();
                ACTION = ADDITION;
                t2.setText(String.valueOf(val1) + "+");
                t1.setText(null);
                break;
            case R.id.button_sub:
                computeCalculation();
                ACTION = SUBTRACTION;
                t2.setText(String.valueOf(val1) + "-");
                t1.setText(null);
                break;
            case R.id.button_mult:
                computeCalculation();
                ACTION = MULTIPLICATION;
                t2.setText(String.valueOf(val1) + "*");
                t1.setText(null);
                break;
            case R.id.button_div:
                computeCalculation();
                ACTION = DIVISION;
                t2.setText(String.valueOf(val1) + "/");
                t1.setText(null);
                break;
            case R.id.button_module:
                computeCalculation();
                ACTION = MODULUS;
                t2.setText(String.valueOf(val1) + "%");
                t1.setText(null);
                break;
            case R.id.button_dot:
                t1.setText(t1.getText() + ".");
                break;
            case R.id.light:
                getWindow().getDecorView().setBackgroundResource(R.color.colorPrimary);
                t1.setTextColor(Color.BLACK);
                t2.setTextColor(Color.BLACK);
                night.setEnabled(true);
                light.setEnabled(false);
                night.setImageResource(R.drawable.night);
                break;
            case R.id.night:
                getWindow().getDecorView().setBackgroundResource(R.color.colorPrimaryDark);
                t1.setTextColor(Color.WHITE);
                t2.setTextColor(Color.WHITE);
                light.setEnabled(true);
                night.setEnabled(false);
                light.setImageResource(R.drawable.light);
                break;
        }
        }catch (Exception e){
            t1.setText("ERROR");
        }
    }

    private void computeCalculation() {
        if(!Double.isNaN(val1)) {
            val2 = Double.parseDouble(t1.getText().toString());
            t1.setText(null);
            if(ACTION == ADDITION) {
                val1 = this.val1 + val2;
            }else if(ACTION == SUBTRACTION) {
                val1 = this.val1 - val2;
            }else if(ACTION == MULTIPLICATION) {
                val1 = this.val1 * val2;
            }else if(ACTION == DIVISION) {
                val1 = this.val1 / val2;}
            }else if(ACTION == MODULUS) {
            val1 = this.val1 % val2;
            }
//            else if(ACTION == SUBTRACTION) {
//                val1 = this.val1 - val2;}
            else {
                val1 = Double.parseDouble(t1.getText().toString());
        }
    }
}