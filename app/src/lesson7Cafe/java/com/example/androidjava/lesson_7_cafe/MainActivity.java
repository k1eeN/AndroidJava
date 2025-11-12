package com.example.androidjava.lesson_7_cafe;

import android.content.Intent;
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

import com.example.androidjava.R;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editPassword;
    private Button buttonSignIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initViews();

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editTextName.getText().toString().trim();
                String userPassword = editPassword.getText().toString().trim();

                if (userName.isEmpty() || userPassword.isEmpty()) {
                    Toast.makeText(
                            MainActivity.this,
                            R.string.error_empty,
                            Toast.LENGTH_SHORT
                    ).show();
                } else {
                    launchNextScreen(userName);
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void launchNextScreen (String userName) {
        Intent intent = MakeOrderActivity.newIntent(this, userName);
        startActivity(intent);
    }

    private void initViews () {
        editTextName = findViewById(R.id.editTextName);
        editPassword = findViewById(R.id.editPassword);
        buttonSignIn = findViewById(R.id.buttonSignIn);
    }

}