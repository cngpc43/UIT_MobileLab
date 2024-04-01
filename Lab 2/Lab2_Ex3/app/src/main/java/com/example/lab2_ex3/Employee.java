package com.example.lab2_ex3;

import androidx.annotation.NonNull;

public abstract class Employee {
    public String id;
    public String name;
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    abstract int TinhLuong();
    @NonNull
    @Override
    public abstract String toString();


}
