package com.university;

public class Pc {
    String systemId;
    String systemName;
    String systemSpeed;
    String ramSize;
    String hardDiskSize;
    String screenSize;

    public Pc(String systemId, String systemName, String systemSpeed, String ramSize, String hardDiskSize, String screenSize) {
        this.systemId = systemId;
        this.systemName = systemName;
        this.systemSpeed = systemSpeed;
        this.ramSize = ramSize;
        this.hardDiskSize = hardDiskSize;
        this.screenSize = screenSize;
    }

    public String getSystemDetails() {
        return "System Id: " + this.systemId + " | System Name: " + this.systemName + " | System Speed: " + this.systemSpeed + "| RAM Size: " + this.ramSize + " | Hard Disk Size: " + this.hardDiskSize + " | LCD Make Model: " + this.screenSize;
    }

}