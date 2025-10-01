package com.edtech.vcm.repository;

import com.edtech.vcm.model.Student;

import java.util.*;

public class StudentRepository {
    private final Map<String, Student> students = new HashMap<>();

    public void save(Student student) {
        students.put(student.getId(), student);
    }

    public Student findById(String id) {
        return students.get(id);
    }

    public Collection<Student> findAll() {
        return students.values();
    }
}
