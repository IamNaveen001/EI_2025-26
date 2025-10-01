package com.edtech.vcm.service;

import com.edtech.vcm.exception.DuplicateEntityException;
import com.edtech.vcm.exception.NotFoundException;
import com.edtech.vcm.model.Classroom;
import com.edtech.vcm.model.Student;
import com.edtech.vcm.repository.StudentRepository;
import com.edtech.vcm.utils.LoggerFactory;

import java.util.logging.Logger;

public class StudentService {
    private final Logger logger = LoggerFactory.getLogger(StudentService.class);
    private final StudentRepository repository = new StudentRepository();
    private final ClassroomService classroomService;

    public StudentService(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    public void addStudent(String id, String className) {
        if (repository.findById(id) != null) {
            throw new DuplicateEntityException("Student already exists: " + id);
        }
        Classroom classroom = classroomService.getClassroom(className);
        Student student = new Student(id, className);
        repository.save(student);
        classroom.getStudents().put(id, student);
        logger.info("Student " + id + " has been enrolled in " + className + ".");
    }

    public void listStudents(String className) {
        Classroom classroom = classroomService.getClassroom(className);
        if (classroom.getStudents().isEmpty()) {
            logger.info("No students in " + className);
            return;
        }
        classroom.getStudents().values().forEach(s -> System.out.println("- " + s.getId()));
    }

    public Student getStudent(String id) {
        Student student = repository.findById(id);
        if (student == null) throw new NotFoundException("Student not found: " + id);
        return student;
    }
}
