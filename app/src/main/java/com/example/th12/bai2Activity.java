package com.example.th12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;

public class bai2Activity extends AppCompatActivity {
    private TextView textViewNumbers;
    private int[] numbers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        textViewNumbers = findViewById(R.id.textViewNumbers);
        numbers = new int[]{};

        updateNumbersTextView();
    }
    public void openInputActivity(View view) {
        Intent intent = new Intent(this, InputActivity.class);
        startActivityForResult(intent, 1);
    }

    public void sortNumbers(View view) {
        Arrays.sort(numbers);
        updateNumbersTextView();
    }

    public void searchNumber(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        intent.putExtra("numbers", numbers);
        startActivity(intent);
    }

    public void closeApp(View view) {
        finish();
    }

    private void updateNumbersTextView() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int number : numbers) {
            stringBuilder.append(number).append(" ");
        }
        textViewNumbers.setText(stringBuilder.toString().trim());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            String input = data.getStringExtra("input");
            if (input != null && !input.isEmpty()) {
                String[] numbersStr = input.split("\\s+");
                numbers = new int[numbersStr.length];
                for (int i = 0; i < numbersStr.length; i++) {
                    numbers[i] = Integer.parseInt(numbersStr[i]);
                }
                updateNumbersTextView();
            }
        }
    }
}