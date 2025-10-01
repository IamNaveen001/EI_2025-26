package com.edtech.vcm.model;

import java.util.*;

public class Student {
    private final String id;
    private final String className;
    private final List<Submission> submissions = new ArrayList<>();

    public Student(String id, String className) {
        this.id = id;
        this.className = className;
    }

    public String getId() { return id; }
    public String getClassName() { return className; }
    public List<Submission> getSubmissions() { return submissions; }
}
