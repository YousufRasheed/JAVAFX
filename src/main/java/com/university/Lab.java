package com.university;

import java.util.ArrayList;

public class Lab {
    String labName;
    LabStaff labIncharge;
    Boolean hasProjector;
    ArrayList<Pc> pcs = new ArrayList<Pc>();

    public Lab(String labName, LabStaff labIncharge, Boolean hasProjector) {
        this.labName = labName;
        this.labIncharge = labIncharge;
        this.hasProjector = hasProjector;
    }

    public void addPc(Pc pc) {
        this.pcs.add(pc);
    }

    public void removePc(Pc pc) {
        this.pcs.remove(pc);
    }

    public Pc getPc(String systemId) {
        for (Pc pc : this.pcs) {
            if (pc.systemId.equals(systemId)) {
                System.out.println(pc.getSystemDetails());
            }
        }
        return null;
    }

    public String getLabName() {
        return this.labName;
    }

    public String getLabInchargeName() {
        return this.labIncharge.staffDetails.name;
    }

    public String getLabInchargeGrade() {
        return this.labIncharge.staffDetails.grade;
    }
}
