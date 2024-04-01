package com.example.lab2_ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Employee> employees = new ArrayList<>();
        ListView lvEmployee = findViewById(R.id.lvEmployee);
        EmployeeAdapter adapter = new EmployeeAdapter(
                this,
                R.layout.item_employee,
                employees
        );
        findViewById(R.id.btnAdd).setOnClickListener(v -> {
            runOnUiThread(() -> {
                addNewEmployee(employees, adapter);
                adapter.notifyDataSetChanged();
            });
        });
        lvEmployee.setAdapter(adapter);

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
