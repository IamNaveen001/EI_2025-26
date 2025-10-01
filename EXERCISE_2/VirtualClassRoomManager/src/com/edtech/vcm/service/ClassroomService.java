package com.edtech.vcm.service;

import com.edtech.vcm.exception.DuplicateEntityException;
import com.edtech.vcm.exception.NotFoundException;
import com.edtech.vcm.model.Classroom;
import com.edtech.vcm.repository.ClassroomRepository;
import com.edtech.vcm.utils.LoggerFactory;

import java.util.logging.Logger;

public class ClassroomService {
    private final Logger logger = LoggerFactory.getLogger(ClassroomService.class);
    private final ClassroomRepository repository = new ClassroomRepository();

    public void addClassroom(String name) {
        if (repository.findByName(name) != null) {
            throw new DuplicateEntityException("Classroom already exists: " + name);
        }
        repository.save(new Classroom(name));
        logger.info("Classroom " + name + " has been created.");
    }

    public void listClassrooms() {
        if (repository.findAll().isEmpty()) {
            logger.info("No classrooms available.");
            return;
        }
        repository.findAll().forEach(c -> System.out.println("- " + c.getName()));
    }

    public void removeClassroom(String name) {
        if (repository.findByName(name) == null) {
            throw new NotFoundException("Classroom not found: " + name);
        }
        repository.delete(name);
        logger.info("Classroom " + name + " has been removed.");
    }

    public Classroom getClassroom(String name) {
        Classroom classroom = repository.findByName(name);
        if (classroom == null) throw new NotFoundException("Classroom not found: " + name);
        return classroom;
    }
}
