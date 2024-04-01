package com.example.lab2_ex3;

import androidx.annotation.NonNull;

public class EmployeeParttime extends Employee{
    public EmployeeParttime() {
    }
    public EmployeeParttime(String id, String name) {
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
        return(super.id + " - "+super.name + "--> PartTime Employee");
    }
}
