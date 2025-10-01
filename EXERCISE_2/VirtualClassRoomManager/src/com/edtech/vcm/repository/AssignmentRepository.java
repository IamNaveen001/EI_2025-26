package com.edtech.vcm.repository;

import com.edtech.vcm.model.Assignment;

import java.util.*;

public class AssignmentRepository {
    private final List<Assignment> assignments = new ArrayList<>();

    public void save(Assignment assignment) {
        assignments.add(assignment);
    }

    public List<Assignment> findAll() {
        return assignments;
    }
}
