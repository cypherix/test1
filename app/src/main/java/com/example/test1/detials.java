package com.example.test1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class detials extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detials);
        EditText name = findViewById(R.id.name);
        EditText register = findViewById(R.id.register);
        EditText department = findViewById(R.id.department);
        Button next = findViewById(R.id.next);
        next.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(detials.this, calculator.class);
                        startActivity(intent);
                    }
                }
        );

        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        register.setText(intent.getStringExtra("register"));
        department.setText(intent.getStringExtra("department"));
    }


}