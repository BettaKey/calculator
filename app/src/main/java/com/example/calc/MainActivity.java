package com.example.calc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

public class MainActivity extends AppCompatActivity {

    EditText input;
    String curNum = "";
    boolean operOn = false;
    Button[] numButns = new Button[10];
    Operation curOper = null;
    double frstNum = 0;
    double scndNum = 0;

    enum Operation {
        ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);

        for (int i = 0; i < numButns.length; i++) {
            int btnId = getResources().getIdentifier("btn_" + i, "id", getPackageName());
            numButns[i] = findViewById(btnId);
            int value = i;
            numButns[i].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (operOn) {
                        curNum = "";
                        operOn = false;
                    }
                    curNum += String.valueOf(value);
                    input.setText(curNum);
                }
            });
        }
    }

    public void Click_add(View v) {
        curOper = Operation.ADDITION;
        calculate();
        operOn = true;
    }

    public void Click_sub(View v) {
        curOper = Operation.SUBTRACTION;
        calculate();
        operOn = true;
    }

    public void Click_mul(View v) {
        curOper = Operation.MULTIPLICATION;
        calculate();
        operOn = true;
    }

    public void Click_div(View v) {
        curOper = Operation.DIVISION;
        calculate();
        operOn = true;
    }

    public void Click_equal(View v) {
        calculate();
        operOn = true;
    }

    public void Click_clear(View v) {
        Button B0 = findViewById(R.id.btn_0);
        Button B1 = findViewById(R.id.btn_1);
        Button B2 = findViewById(R.id.btn_2);
        Button B3 = findViewById(R.id.btn_3);
        Button B4 = findViewById(R.id.btn_4);
        Button B5 = findViewById(R.id.btn_5);
        Button B6 = findViewById(R.id.btn_6);
        Button B7 = findViewById(R.id.btn_7);
        Button B8 = findViewById(R.id.btn_8);
        Button B9 = findViewById(R.id.btn_9);
        Button Badd = findViewById(R.id.btn_add);
        Button Bsub = findViewById(R.id.btn_sub);
        Button Bmul = findViewById(R.id.btn_mul);
        Button Bdiv = findViewById(R.id.btn_div);
        Button Bequ = findViewById(R.id.btn_equal);
        TextView head = findViewById(R.id.head);

        B0.setVisibility(View.GONE);
        B1.setVisibility(View.GONE);
        B2.setVisibility(View.GONE);
        B3.setVisibility(View.GONE);
        B4.setVisibility(View.GONE);
        B5.setVisibility(View.GONE);
        B6.setVisibility(View.GONE);
        B7.setVisibility(View.GONE);
        B8.setVisibility(View.GONE);
        B9.setVisibility(View.GONE);
        Badd.setVisibility(View.GONE);
        Bsub.setVisibility(View.GONE);
        Bmul.setVisibility(View.GONE);
        Bdiv.setVisibility(View.GONE);
        Bequ.setVisibility(View.GONE);
        head.setVisibility(View.GONE);
    }

    private void calculate() {
        if (curOper != null) {
            scndNum = Double.parseDouble(curNum);
            switch (curOper) {
                case ADDITION:
                    frstNum = frstNum + scndNum;
                    break;
                case SUBTRACTION:
                    frstNum = frstNum - scndNum;
                    break;
                case MULTIPLICATION:
                    frstNum = frstNum * scndNum;
                    break;
                case DIVISION:
                    frstNum = frstNum / scndNum;
                    break;
            }
            input.setText(String.valueOf(frstNum));
            curNum = "";
        } else {
            frstNum = Double.parseDouble(curNum);
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence("text", input.getText());
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        input.setText(savedInstanceState.getCharSequence("text"));
    }

    public void RickOnClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
