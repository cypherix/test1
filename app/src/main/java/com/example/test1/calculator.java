package com.example.test1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);
        Button plus = findViewById(R.id.plus);
        Button minus = findViewById(R.id.minus);
        Button division = findViewById(R.id.division);
        Button multiply = findViewById(R.id.multiply);
        EditText first = findViewById(R.id.firstnumber);
        EditText second = findViewById(R.id.secondnumber);
        EditText result = findViewById(R.id.result);


        plus.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String firstN =  first.getText().toString();
                        String secondN = second.getText().toString();

                        result.setText("reslt = "+(extractINT(firstN)+extractINT(secondN)));
                    }
                }
        );

        minus.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String firstN =  first.getText().toString();
                        String secondN = second.getText().toString();
                        result.setText("reslt = "+ (extractINT(firstN)-extractINT(secondN)) );
                    }
                }
        );
        division.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String firstN =  first.getText().toString();
                        String secondN = second.getText().toString();
                        if (secondN.equals('0')) Toast.makeText(calculator.this, "0 is not applicable", Toast.LENGTH_SHORT).show();
                        else result.setText("reslt = "+(extractINT(firstN)/extractINT(secondN)));
                    }
                }
        );
        multiply.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String firstN =  first.getText().toString();
                        String secondN = second.getText().toString();

                        result.setText("reslt = "+(extractINT(firstN)*extractINT(secondN)));
                    }
                }
        );


    }

    int extractINT(String s){
        int number=0;
        for (int i = 0; i <s.length(); i++) {
            int digit = (int) s.charAt(i);
            digit = digit*(int) Math.pow(10,s.length()-i-1);
            number+=digit;
        }
        return number;
    }

}