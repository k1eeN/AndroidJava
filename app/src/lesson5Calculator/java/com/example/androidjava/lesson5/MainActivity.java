package com.example.androidjava.lesson_6_game_score;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.androidjava.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText editTextAnswer = findViewById(R.id.editTextAnswer);
        Button buttonAnswer = findViewById(R.id.buttonAnswer);
        TextView textViewCorrect = findViewById(R.id.textViewCorrect);
        TextView textViewIncorrect = findViewById(R.id.textViewIncorrect);
        TextView textViewExample = findViewById(R.id.textViewExample);

        textViewExample.setText("10 + 20 = ?");

        buttonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editTextAnswer.getText().toString();
                if (text.equals("30")) {
                    textViewCorrect.setVisibility(View.VISIBLE);
                    textViewIncorrect.setVisibility(View.GONE);
                } else {
                    textViewCorrect.setVisibility(View.GONE);
                    textViewIncorrect.setVisibility(View.VISIBLE);
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}