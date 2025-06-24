package com.example.hesapmakinsison;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView txtResult;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private Button btnEk, btnCik, btnCarp, btnBol, btnSil, btnSnc, btnVir, btnDel;

    private double firstValue = 0;
    private double secondValue = 0;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtResult = findViewById(R.id.textResult);

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

        btnEk = findViewById(R.id.btnEk);
        btnCik = findViewById(R.id.btnCik);
        btnCarp = findViewById(R.id.btnCarp);
        btnBol = findViewById(R.id.btnBol);
        btnSil = findViewById(R.id.btnSil);
        btnSnc = findViewById(R.id.btnSnc);
        btnVir = findViewById(R.id.btnVrg);
        btnDel = findViewById(R.id.btnTem);


        View.OnClickListener numberListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                txtResult.append(button.getText().toString());
            }
        };

        btn0.setOnClickListener(numberListener);
        btn1.setOnClickListener(numberListener);
        btn2.setOnClickListener(numberListener);
        btn3.setOnClickListener(numberListener);
        btn4.setOnClickListener(numberListener);
        btn5.setOnClickListener(numberListener);
        btn6.setOnClickListener(numberListener);
        btn7.setOnClickListener(numberListener);
        btn8.setOnClickListener(numberListener);
        btn9.setOnClickListener(numberListener);


        btnEk.setOnClickListener(view -> setOperator("+"));
        btnCik.setOnClickListener(view -> setOperator("-"));
        btnCarp.setOnClickListener(view -> setOperator("x"));
        btnBol.setOnClickListener(view -> setOperator("/"));


        btnSnc.setOnClickListener(view -> calculateResult());


        btnSil.setOnClickListener(view -> clear());


        btnVir.setOnClickListener(view -> addDecimalPoint());


        btnDel.setOnClickListener(view -> deleteLastCharacter());
    }

    private void setOperator(String op) {
        if (!txtResult.getText().toString().isEmpty()) {
            firstValue = Double.parseDouble(txtResult.getText().toString());
            operator = op;
            txtResult.setText("");
        }
    }

    private void calculateResult() {
        if (!txtResult.getText().toString().isEmpty() && !operator.isEmpty()) {
            secondValue = Double.parseDouble(txtResult.getText().toString());
            double result = 0;

            switch (operator) {
                case "+":
                    result = firstValue + secondValue;
                    break;
                case "-":
                    result = firstValue - secondValue;
                    break;
                case "x":
                    result = firstValue * secondValue;
                    break;
                case "/":
                    if (secondValue != 0) {
                        result = firstValue / secondValue;
                    } else {
                        txtResult.setText("Error");
                        return;
                    }
                    break;
            }

            txtResult.setText(String.valueOf(result));
            operator = "";
        }
    }

    private void clear() {
        txtResult.setText("");
        firstValue = 0;
        secondValue = 0;
        operator = "";
    }


    private void addDecimalPoint() {
        String currentText = txtResult.getText().toString();
        if (!currentText.contains(".")) {
            txtResult.append(".");
        }
    }


    private void deleteLastCharacter() {
        String currentText = txtResult.getText().toString();
        if (currentText.length() > 0) {
            txtResult.setText(currentText.substring(0, currentText.length() - 1));
        }
    }
}
