package com.edtech.vcm.model;

import java.util.*;

public class Classroom {
    private final String name;
    private final Map<String, Student> students = new HashMap<>();
    private final List<Assignment> assignments = new ArrayList<>();

    public Classroom(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public Map<String, Student> getStudents() { return students; }
    public List<Assignment> getAssignments() { return assignments; }
}
