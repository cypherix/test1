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

public class enter_details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_enter_details);

        EditText name = findViewById(R.id.name);
        EditText register = findViewById(R.id.register);
        EditText department = findViewById(R.id.department);
        Button submit = findViewById(R.id.submit);

        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(enter_details.this, detials.class);

                        intent.putExtra("name",
                                name.getText().toString().trim());
                        intent.putExtra("register",
                                register.getText().toString().trim());
                        intent.putExtra("department",
                                department.getText().toString().trim());

                        startActivity(intent);
                    }

                }
        );
    }
}