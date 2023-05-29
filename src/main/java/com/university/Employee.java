package com.university;

public class Employee {
    String name;
    String grade;

    public Employee(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getEmployeeDetails() {
        return "Name: " + this.name + "\nGrade: " + this.grade;
    }
}
