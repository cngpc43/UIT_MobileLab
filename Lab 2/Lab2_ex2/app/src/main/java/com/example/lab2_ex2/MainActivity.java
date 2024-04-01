package com.example.lab2_ex2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);
        Button btnSubmit = findViewById(R.id.button);
        ArrayList<String> data = new ArrayList<>(Arrays.asList("tèo", "tý", "bin", "bo"));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                data
        );
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText el = findViewById(R.id.editText);
                String text = el.getText().toString();
                adapter.add(text);
                adapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = findViewById(R.id.selectedItem);
                String selectedItem = adapter.getItem(position);
                String itemDetails = "Position: " + position + ", value: " + selectedItem;
                textView.setText(itemDetails);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                data.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

        listView.setAdapter(adapter);

    }
}