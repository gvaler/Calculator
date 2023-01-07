package com.example.calculator;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private Button btnAC, btnUD, btnPer, btnDiv,
            btn1, btn2, btn3,btn4,btn5, btnMult,
            btn6, btn7, btn8, btn9,btnMin,
            btn0, btnPoint, btnEq,btnPlus;
    private TextView result;
    private String num = "";
    private String num2 = "";
    private String action = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnAC = findViewById(R.id.btnAC);
        btnUD = findViewById(R.id.btnUpsideDown);
        btnPer = findViewById(R.id.btnPer);
        btnDiv = findViewById(R.id.btnDiv);
        btnMult = findViewById(R.id.btnMult);
        btnMin = findViewById(R.id.btnMin);
        btnPlus = findViewById(R.id.btnPlus);
        btnEq = findViewById(R.id.btnEq);
        btnPoint = findViewById(R.id.btnPoint);
        result = findViewById(R.id.result);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(action.isEmpty())setFirstNum(btn1);
                else setSecondNum(btn1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(action.isEmpty())setFirstNum(btn2);
                else setSecondNum(btn2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(action.isEmpty())setFirstNum(btn3);
                else setSecondNum(btn3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(action.isEmpty())setFirstNum(btn4);
                else setSecondNum(btn4);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(action.isEmpty())setFirstNum(btn5);
                else setSecondNum(btn5);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(action.isEmpty())setFirstNum(btn6);
                else setSecondNum(btn6);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(action.isEmpty())setFirstNum(btn7);
                else setSecondNum(btn7);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(action.isEmpty())setFirstNum(btn8);
                else setSecondNum(btn8);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(action.isEmpty())setFirstNum(btn9);
                else setSecondNum(btn9);
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(action.isEmpty())setFirstNum(btn0);
                else setSecondNum(btn0);
            }
        });

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = "";
                result.setText("0");
                action = "";
                num2 = "";
            }
        });

        btnUD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int temp = Integer.valueOf(num);
                    temp *= -1;
                    num = Integer.toString(temp);
                    result.setText(num);
                }catch (Exception e){
                    double temp = Double.valueOf(num);
                    temp *= -1;
                    num = Double.toString(temp);
                    result.setText(num);
                }
            }
        });

        btnPer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double temp = Double.parseDouble(num)/100;
                num = Double.toString(temp);
                result.setText(num);
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action = "+";
                calculate();
            }
        });

        btnMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action = "-";
                calculate();
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action = "/";
                calculate();
            }
        });

        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action = "*";
                calculate();
            }
        });

        btnEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }
        });

        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(action.isEmpty())setFirstNum(btnPoint);
                else setSecondNum(btnPoint);
            }
        });
    }

    private void setSecondNum(Button btn) {
        if(btn.getId() != btnPoint.getId()){
            if(num2.length()<8 || (num2.charAt(0)=='-' && num2.length()<9)){
                num2+=(btn.getText().toString()).trim();
                result.setText(num2);
            }
        }else{
            if(checkPoint(num2)>1){
                if(num2.length()<8 || (num2.charAt(0)=='-' && num2.length()<9)){
                    num2+=(btn.getText().toString()).trim();
                    result.setText(num2);
                }
            }
        }
    }

    public void setFirstNum(Button btn) {
        if (btn.getId() != btnPoint.getId()) {
            if (num.length() < 8 || (num.charAt(0) == '-' && num.length() < 9)) {
                num += (btn.getText().toString()).trim();
                result.setText(num);
            }
        } else {
            if (checkPoint(num) < 1) {
                if (num.length() < 8 || (num.charAt(0) == '-' && num.length() < 9)) {
                    num += (btn.getText().toString()).trim();
                    result.setText(num);
                }
            }
        }
    }

    public void calculate(){
        if(!action.isEmpty() && !num2.equals("")){
            if(action.equals("+")){
                try {
                    int temp = Integer.parseInt(num)+Integer.parseInt(num2);
                    intSeter(temp);
                }catch (Exception e){
                    double temp = Double.parseDouble(num)+Double.parseDouble(num2);
                    doubleSeter(temp);
                }
            }
            if(action.equals("-")){
                try {
                    int temp = Integer.parseInt(num)-Integer.parseInt(num2);
                    intSeter(temp);
                }catch (Exception e){
                    double temp = Double.parseDouble(num)-Double.parseDouble(num2);
                    doubleSeter(temp);
                }
            }
            if(action.equals("/")){
                try {
                    int temp = Integer.parseInt(num) / Integer.parseInt(num2);
                    intSeter(temp);
                } catch (Exception e) {
                    double temp = Double.parseDouble(num) / Double.parseDouble(num2);
                    doubleSeter(temp);
                }
            }
            if(action.equals("*")){
                try {
                    int temp = Integer.parseInt(num)*Integer.parseInt(num2);
                    intSeter(temp);
                }catch (Exception e){
                    double temp = Double.parseDouble(num)*Double.parseDouble(num2);
                    doubleSeter(temp);
                }
            }
        }
        if(action.isEmpty() & !num2.equals(""))return;
    }

    public void intSeter(int temp){
        num = Integer.toString(temp);
        num2 = "";
        result.setText(""+num);
    }

    public void doubleSeter(double temp){
        num = Double.toString(temp);
        num2 = "";
        result.setText(""+num);
    }

    private int checkPoint(String number) {
        int counter = 0;
        for (int i = 0; i < number.length()-1; i++) {
            if(number.charAt(i) == '.') counter++;
        }
        return counter;
    }
}