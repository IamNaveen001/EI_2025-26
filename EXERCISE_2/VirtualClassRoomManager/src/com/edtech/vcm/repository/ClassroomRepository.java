package com.edtech.vcm.repository;

import com.edtech.vcm.model.Classroom;

import java.util.*;

public class ClassroomRepository {
    private final Map<String, Classroom> classrooms = new HashMap<>();

    public void save(Classroom classroom) {
        classrooms.put(classroom.getName(), classroom);
    }

    public Classroom findByName(String name) {
        return classrooms.get(name);
    }

    public void delete(String name) {
        classrooms.remove(name);
    }

    public Collection<Classroom> findAll() {
        return classrooms.values();
    }
}
