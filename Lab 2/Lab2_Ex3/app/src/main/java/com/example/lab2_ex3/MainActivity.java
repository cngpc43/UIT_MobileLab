package com.example.lab2_ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import android.widget.Toast;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> employees = new ArrayList<>();
        ListView lvEmployee = findViewById(R.id.lvNhanVien);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                employees
        );
        findViewById(R.id.insert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        addNewEmployee(employees, adapter);
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });
        lvEmployee.setAdapter(adapter);
    }
    public void addNewEmployee(ArrayList<String> employees, ArrayAdapter<String> adapter) {

        EditText etId = findViewById(R.id.etMaNV);
        EditText etName = findViewById(R.id.etTenNV);
        RadioGroup rgType = findViewById(R.id.rgTypeNV);

        String id = etId.getText().toString();
        String name = etName.getText().toString();

        if (id.isEmpty() || name.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter all the required information", Toast.LENGTH_SHORT).show();
            return;
        }

        int radId = rgType.getCheckedRadioButtonId();
        Employee employee;
        if (radId == R.id.fulltime) {
            employee = new EmployeeFulltime();
        } else {
            employee = new EmployeeParttime();
        }
        employee.setId(id);
        employee.setName(name);
        String employeeContent = employee.toString();
        employees.add(employeeContent);
        adapter.notifyDataSetChanged();
    }
}
