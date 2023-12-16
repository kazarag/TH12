package com.example.th12;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class bai1Activity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> dataList;
    private ArrayAdapter<String> adapter;
    private ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        Button button = findViewById(R.id.btnnhapbai1);
        listView = findViewById(R.id.listview);
        dataList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               try{
                   Intent intent = new Intent(bai1Activity.this, InputDialogActivity.class);
                   startActivityForResult(intent, 1);
               }
                catch (Exception e){
                    Toast.makeText(bai1Activity.this, "added fail", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            String result = data.getStringExtra("result");
            if (result != null) {
                dataList.add(result);
                adapter.notifyDataSetChanged();
            }
        }
    }

}