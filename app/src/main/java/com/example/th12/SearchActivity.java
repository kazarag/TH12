package com.example.th12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class SearchActivity extends AppCompatActivity {
    private int[] numbers;
    private EditText editTextSearch;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        editTextSearch = findViewById(R.id.editTextSearch);
        textViewResult = findViewById(R.id.textViewResult);

        Intent intent = getIntent();
        if (intent != null) {
            numbers = intent.getIntArrayExtra("numbers");
            Arrays.sort(numbers);
        }
    }
    public void search(View view) {
        String searchStr = editTextSearch.getText().toString().trim();
        if (!searchStr.isEmpty()) {
            int searchNumber = Integer.parseInt(searchStr);
            int index = Arrays.binarySearch(numbers, searchNumber);

            if (index >= 0) {
                textViewResult.setText("Số " + searchNumber + " có trong dãy số.");
            } else {
                textViewResult.setText("Số " + searchNumber + " không có trong dãy số.");
            }
        }
    }
}