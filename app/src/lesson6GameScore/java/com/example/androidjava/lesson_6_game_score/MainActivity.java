package com.example.androidjava.lesson_7_cafe;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.androidjava.R;

public class MainActivity extends AppCompatActivity {

    private int score1 = 0;
    private int score2 = 0;

    private TextView textViewTeam1Score;
    private TextView textViewTeam2Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "onCreate");

        if (savedInstanceState != null) {
            score1 = savedInstanceState.getInt("score1");
            score2 = savedInstanceState.getInt("score2");
        }

        textViewTeam1Score = findViewById(R.id.textViewTeam1Score);
        textViewTeam2Score = findViewById(R.id.textViewTeam2Score);

        updateScore1();
        updateScore2();

        textViewTeam1Score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Clicked textViewTeam1Score");
                score1++;
                updateScore1();
            }
        });
        textViewTeam2Score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Clicked textViewTeam2Score");
                score2++;
                updateScore2();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void updateScore1() {
        textViewTeam1Score.setText(String.valueOf(score1));
    }

    private void updateScore2() {
        textViewTeam2Score.setText(String.valueOf(score2));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d("MainActivity", "onSaveInstanceState");
        super.onSaveInstanceState(outState);
        outState.putInt("score1", score1);
        outState.putInt("score2", score2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy");
    }
}