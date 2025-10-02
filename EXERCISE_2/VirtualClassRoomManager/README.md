# Virtual Classroom Manager Application

A robust Java-based Virtual Classroom Management System that efficiently handles classroom operations, student management, and assignment tracking. The application is designed with clean architecture principles ensuring maintainability, scalability, and reliable functionality.

## Class Diagram

<img src="classDiagram.png">

## Core Features

- **Classroom Management**
  - Create and manage virtual classrooms
  - List all available classrooms
  - Remove classrooms when needed
  - Track classroom membership

- **Student Management**
  - Add students to classrooms
  - Track student enrollment
  - View student listings per classroom
  - Manage student participation

- **Assignment System**
  - Schedule assignments for classrooms
  - Submit assignments (student functionality)
  - Track assignment submissions
  - List all assignments per classroom

- **Error Handling & Validation**
  - Input validation for all operations
  - Duplicate entry prevention
  - Not found entity handling
  - Transient operation retry mechanism

- **Logging System**
  - Comprehensive operation logging
  - Error and warning tracking
  - Activity monitoring
  - Debug information for troubleshooting

## Project Structure

### Core Packages
- `com.edtech.vcm.Application` — Main application entry point
- `com.edtech.vcm.controller.CLIController` — Command-line interface handler

### Service Layer
- `com.edtech.vcm.service.*`
  - `ClassroomService` — Manages classroom operations
  - `StudentService` — Handles student-related functionality
  - `AssignmentService` — Controls assignment operations

### Repository Layer
- `com.edtech.vcm.repository.*`
  - `ClassroomRepository` — Classroom data management
  - `StudentRepository` — Student data management
  - `AssignmentRepository` — Assignment data storage

### Model Layer
- `com.edtech.vcm.model.*`
  - `Classroom` — Classroom entity
  - `Student` — Student entity
  - `Assignment` — Assignment entity
  - `Submission` — Assignment submission entity

### Exception Handling
- `com.edtech.vcm.exception.*`
  - `ValidationException` — Input validation errors
  - `NotFoundException` — Entity not found errors
  - `DuplicateEntityException` — Duplicate entry errors
  - `TransientException` — Temporary operation failures

### Utility Classes
- `com.edtech.vcm.utils.*`
  - `LoggerFactory` — Centralized logging
  - `ValidationUtils` — Input validation
  - `RetryExecutor` — Operation retry mechanism

## Available Commands

```
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
```

## Design Patterns Used

- **Repository Pattern**: For data access abstraction
- **Service Layer Pattern**: For business logic encapsulation
- **Factory Pattern**: For logger creation
- **Command Pattern**: For CLI command processing
- **Singleton Pattern**: For logging and repository instances

## Technical Features

- **Concurrent Operation Support**
  - Thread-safe repository operations
  - Concurrent student submissions handling
  - Safe classroom management

- **Extensible Architecture**
  - Easy to add new features
  - Modular design
  - Clear separation of concerns

- **Robust Error Handling**
  - Comprehensive exception hierarchy
  - Proper error messages
  - Retry mechanism for transient failures

## Run Instructions (Windows)

From the repository root in Command Prompt or PowerShell, run:

```powershell
# Create a list of source files
dir /S /B src\*.java > sources.txt

# Compile the application
javac @sources.txt -d out

# Run the application
java -cp out com.edtech.vcm.Application
```

## Development Guidelines

1. **Adding New Features**
   - Place business logic in appropriate service classes
   - Create new repositories for new entities
   - Add corresponding model classes
   - Update CLI controller for new commands

2. **Error Handling**
   - Use appropriate exception types
   - Implement proper logging
   - Add validation where necessary

3. **Testing**
   - Test new features thoroughly
   - Ensure proper error handling
   - Verify concurrent operations

## Future Enhancements

1. **Database Integration**
   - Persistent storage support
   - Database transaction management
   - Data backup and recovery

2. **User Authentication**
   - Role-based access control
   - Teacher/Student authentication
   - Session management

3. **Advanced Features**
   - Real-time notifications
   - Assignment grading system
   - Student performance tracking
   - File attachment support for assignments

4. **UI Improvements**
   - Web-based interface
   - Mobile application support
   - Rich text formatting for assignments

## System Requirements

- Java Development Kit (JDK) 17 or higher
- Windows/Linux/MacOS operating system
- Minimum 2GB RAM
- 100MB free disk space

## Notes
- All data is stored in memory and will be lost when the application is closed
- Use meaningful classroom and student IDs for better tracking
- Follow proper command syntax as shown in help menu

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.