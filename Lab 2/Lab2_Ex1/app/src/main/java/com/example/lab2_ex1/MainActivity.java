package com.example.lab2_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);

        String[] data = {"tèo", "tý", "bin", "bo"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                data
        );
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = findViewById(R.id.selectedItem);
                String selectedItem = adapter.getItem(position);
                String itemDetails = "Position: " + position + ", value: " + selectedItem;
                textView.setText(itemDetails);
            }
        });
        listView.setAdapter(adapter);
    }
}