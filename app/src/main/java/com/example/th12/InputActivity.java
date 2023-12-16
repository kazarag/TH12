package com.example.th12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {
    private EditText editTextNumbers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        editTextNumbers = findViewById(R.id.editTextNumbers);
    }
    public void saveNumbers(View view) {
        String input = editTextNumbers.getText().toString().trim();

        Intent resultIntent = new Intent();
        resultIntent.putExtra("input", input);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}