package com.example.lab2_ex4;

import androidx.annotation.NonNull;

public class Employee {
    public String id;
    public String name;
    public boolean isManager;
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setIsManager(boolean isManager) {
        this.isManager = isManager;
    }
    public boolean isManager() {
        return isManager;
    }


    public String getFullName() {
        return name;
    }
}
