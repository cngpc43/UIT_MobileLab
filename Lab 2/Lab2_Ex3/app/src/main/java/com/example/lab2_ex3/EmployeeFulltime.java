package com.example.lab2_ex3;

import androidx.annotation.NonNull;

public class EmployeeFulltime extends Employee{
    public EmployeeFulltime() {
    }

    public EmployeeFulltime(String id, String name, int salary) {
        this.id = id;
        this.name = name;
    }

    @Override
    int TinhLuong() {
        return 500;
    }

    @NonNull
    @Override
    public String toString() {
        return(super.id+" - "+super.name + "--> FullTime Employee");
    }
}
