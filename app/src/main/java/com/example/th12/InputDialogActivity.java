package com.example.th12;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InputDialogActivity extends Activity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_dialog);

        editText = findViewById(R.id.editText);
    }

    public void saveSquare(View view) {
        String input = editText.getText().toString();
        if (!input.isEmpty()) {
            int number = Integer.parseInt(input);
            int square = number * number;

            Intent resultIntent = new Intent();
            resultIntent.putExtra("result", String.valueOf(square));
            setResult(RESULT_OK, resultIntent);
            finish();
        }
    }

    public void saveOriginalNumber(View view) {
        String input = editText.getText().toString();
        if (!input.isEmpty()) {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("result", input);
            setResult(RESULT_OK, resultIntent);
            finish();
        }
    }
}