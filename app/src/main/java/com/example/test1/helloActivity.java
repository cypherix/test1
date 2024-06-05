package com.example.test1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class helloActivity extends AppCompatActivity {
    boolean clicked =true;
    boolean colorClicked =true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hello);

        TextView helloWorld =  findViewById(R.id.helloWorld);
        Button color = findViewById(R.id.color);
        Button size = findViewById(R.id.size);
        Button next = findViewById(R.id.next);

        size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clicked){
                    helloWorld.setTextSize(50);
                    clicked = false;
                }
                else {
                    helloWorld.setTextSize(25);
                    clicked=true;
                }

            }
        });

        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (colorClicked){
                    helloWorld.setTextColor(111111);
                    colorClicked = false;
                }
                else {
                    helloWorld.setTextColor(0);
                    colorClicked=true;
                }

            }
        });
        next.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(helloActivity.this, detials.class);
                        startActivity(intent);
                    }
                }
        );


    }
}