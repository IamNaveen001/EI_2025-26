package com.edtech.vcm.service;

import com.edtech.vcm.model.Assignment;
import com.edtech.vcm.model.Classroom;
import com.edtech.vcm.model.Student;
import com.edtech.vcm.model.Submission;
import com.edtech.vcm.utils.LoggerFactory;

import java.util.logging.Logger;

public class AssignmentService {
    private final Logger logger = LoggerFactory.getLogger(AssignmentService.class);
    private final ClassroomService classroomService;
    private final StudentService studentService;

    public AssignmentService(ClassroomService classroomService, StudentService studentService) {
        this.classroomService = classroomService;
        this.studentService = studentService;
    }

    public void scheduleAssignment(String className, String details) {
        Classroom classroom = classroomService.getClassroom(className);
        classroom.getAssignments().add(new Assignment(details));
        logger.info("Assignment for " + className + " has been scheduled.");
    }

    public void submitAssignment(String studentId, String className, String details) {
        Student student = studentService.getStudent(studentId);
        if (!student.getClassName().equals(className)) {
            throw new IllegalArgumentException("Student is not in class: " + className);
        }
        student.getSubmissions().add(new Submission(studentId, details));
        logger.info("Assignment submitted by Student " + studentId + " in " + className + ".");
    }

    public void listAssignments(String className) {
        Classroom classroom = classroomService.getClassroom(className);
        if (classroom.getAssignments().isEmpty()) {
            logger.info("No assignments in " + className);
            return;
        }
        classroom.getAssignments().forEach(a -> System.out.println("- " + a.getDetails()));
    }
}
