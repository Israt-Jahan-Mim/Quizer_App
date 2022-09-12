package com.creativeitinstitute.quizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DashBoardActivity extends AppCompatActivity {

    LinearLayout bd_quiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        bd_quiz = findViewById(R.id.bd_quiz);



        bd_quiz.setOnClickListener(view -> {

            Intent intent = new Intent(DashBoardActivity.this , PlayActivity.class);
            startActivity(intent);
            
            Toast.makeText(this, "Bangladesh Quiz Clicked", Toast.LENGTH_SHORT).show();
        });

    }


}