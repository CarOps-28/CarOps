package com;

public class AssignmentObject {
    private String id;
    private String plateNumber;
    private String jobName;
    private String assignmentStatus;
    private String cost;
    public AssignmentObject(String id, String plateNumber, String jobName, String assignmentStatus, String cost) {
        this.id = id;
        this.plateNumber = plateNumber;
        this.jobName = jobName;
        this.assignmentStatus = assignmentStatus;
        this.cost = cost;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getAssignmentStatus() {
        return assignmentStatus;
    }

    public void setAssignmentStatus(String assignmentStatus) {
        this.assignmentStatus = assignmentStatus;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }


}
