package com.university;

import java.util.ArrayList;

public class University {
    String name;
    ArrayList<Campus> campuses = new ArrayList<Campus>();

    public University(String name) {
        this.name = name;
    }

    public void addCapmpus(Campus cap){
        this.campuses.add(cap);
    }

    public void removeCampus(Campus cap){
        this.campuses.remove(cap);
    }

    public ArrayList<Campus> getCampuses() {
        return this.campuses;
    }
}
