package com.example.lab2_ex6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Employee> employees = new ArrayList<>();
        RecyclerView rvEmployee = findViewById(R.id.rvEmployee);
        EmployeeAdapter adapter = new EmployeeAdapter(employees);
        rvEmployee.setAdapter(adapter);
        rvEmployee.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.btnAdd).setOnClickListener(v -> {
            runOnUiThread(() -> {
                addNewEmployee(employees, adapter);
                adapter.notifyDataSetChanged();
            });
        });
    }

    public void addNewEmployee(ArrayList<Employee> employees, EmployeeAdapter adapter) {
        EditText etId = findViewById(R.id.etID);
        EditText etName = findViewById(R.id.etName);
        CheckBox isManager = findViewById(R.id.cbManager);

        String id = etId.getText().toString();
        String name = etName.getText().toString();

        if (id.isEmpty() || name.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter all the required information", Toast.LENGTH_SHORT).show();
            return;
        }


        Employee employee;
        if (isManager.isChecked()) {
            employee = new Employee();
            employee.isManager = true;
        } else {
            employee = new Employee();
            employee.isManager = false;
        }
        employee.setId(id);
        employee.setName(name);
        employees.add(employee);
        adapter.notifyDataSetChanged();
    }
}