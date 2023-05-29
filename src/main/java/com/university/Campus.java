package com.university;

import java.util.ArrayList;

public class Campus {
    String name;
    String address;
    Director director;
    ArrayList<Department> departments = new ArrayList<Department>();
    
    public Campus(String name, String address, Director director) {
        this.name = name;
        this.address = address;
        this.director = director;
    }

    public void addDepartment(Department department) {
        this.departments.add(department);
    }

    public void removeDepartment(Department department) {
        this.departments.remove(department);
    }

    public ArrayList<Department> getDepartments() {
        return this.departments;
    }

    public String getDirectorName() {
        return this.director.directorDetails.name;
    }

    public String getDirectorGrade() {
        return this.director.directorDetails.grade;
    }
}
