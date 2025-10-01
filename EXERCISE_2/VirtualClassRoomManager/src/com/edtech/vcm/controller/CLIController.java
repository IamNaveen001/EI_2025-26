package com.edtech.vcm.controller;

import com.edtech.vcm.exception.ValidationException;
import com.edtech.vcm.service.AssignmentService;
import com.edtech.vcm.service.ClassroomService;
import com.edtech.vcm.service.StudentService;
import com.edtech.vcm.utils.LoggerFactory;

import java.util.Scanner;
import java.util.logging.Logger;

public class CLIController {
    private final Logger logger = LoggerFactory.getLogger(CLIController.class);
    private final ClassroomService classroomService = new ClassroomService();
    private final StudentService studentService = new StudentService(classroomService);
    private final AssignmentService assignmentService = new AssignmentService(classroomService, studentService);

    public void start() {
        Scanner scanner = new Scanner(System.in);
        logger.info("Virtual Classroom Manager started. Type 'help' for commands. Type 'exit' to quit.");

        String input;
        do {
            System.out.print("> ");
            input = scanner.nextLine().trim();
            if (input.isEmpty()) continue;

            try {
                processCommand(input);
            } catch (ValidationException e) {
                logger.warning("Validation error: " + e.getMessage());
            } catch (Exception e) {
                logger.severe("Unexpected error: " + e.getMessage());
            }
        } while (!input.equalsIgnoreCase("exit"));

        logger.info("Exiting Virtual Classroom Manager...");
        scanner.close();
    }

    private void processCommand(String input) {
        String[] parts = input.split(" ", 2);
        String command = parts[0];

        switch (command) {
            case "help" -> showHelp();
            case "add_classroom" -> classroomService.addClassroom(parts[1]);
            case "list_classrooms" -> classroomService.listClassrooms();
            case "remove_classroom" -> classroomService.removeClassroom(parts[1]);
            case "add_student" -> {
                String[] tokens = parts[1].split(" ");
                studentService.addStudent(tokens[0], tokens[1]);
            }
            case "list_students" -> studentService.listStudents(parts[1]);
            case "schedule_assignment" -> {
                String[] tokens = parts[1].split(" ", 2);
                assignmentService.scheduleAssignment(tokens[0], tokens[1]);
            }
            case "submit_assignment" -> {
                String[] tokens = parts[1].split(" ", 3);
                assignmentService.submitAssignment(tokens[0], tokens[1], tokens[2]);
            }
            case "list_assignments" -> assignmentService.listAssignments(parts[1]);
            case "exit" -> {} // handled in loop
            default -> logger.warning("Unknown command. Type 'help' for commands.");
        }
    }

    private void showHelp() {
        System.out.println("""
                Commands:
                add_classroom <className>
                list_classrooms
                remove_classroom <className>
                add_student <studentId> <className>
                list_students <className>
                schedule_assignment <className> <assignmentDetails>
                submit_assignment <studentId> <className> <assignmentDetails>
                list_assignments <className>
                exit
                """);
    }
}
