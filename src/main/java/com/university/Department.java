package com.university;

import java.util.ArrayList;

public class Department {;
    String departmentName;
    HOD hod;
    ArrayList<Lab> labs = new ArrayList<Lab>();

    public Department(String name, HOD hod) {
        this.departmentName = name;
        this.hod = hod;
    }

    public void addLab(Lab lab) {
        this.labs.add(lab);
    }

    public void removeLab(Lab lab) {
        this.labs.remove(lab);
    }

    public Lab getLab(String labName) {
        for (Lab lab : this.labs) {
            if (lab.labName.equals(labName)) {
                return lab;
            }
        }
        return null;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public String getHodName() {
        return this.hod.hodDetails.name;
    }

    public String getHodGrade() {
        return this.hod.hodDetails.grade;
    }
}
