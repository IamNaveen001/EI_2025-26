package com.edtech.vcm.model;

public class Submission {
    private final String studentId;
    private final String assignmentDetails;

    public Submission(String studentId, String assignmentDetails) {
        this.studentId = studentId;
        this.assignmentDetails = assignmentDetails;
    }

    public String getStudentId() { return studentId; }
    public String getAssignmentDetails() { return assignmentDetails; }
}
