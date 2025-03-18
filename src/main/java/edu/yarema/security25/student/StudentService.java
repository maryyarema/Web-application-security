package edu.yarema.security25.student;

/*
 * @author Mariia
 * @project security25
 * @class StudentService
 * @version 1.0.0
 * @since {DATE} - 12.51
 */

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    @PostConstruct
    void init() {
        repository.saveAll(List.of(
                new Student( "John", "Doe", "Computer Science"),
                new Student( "Jane", "Smith", "Mathematics"),
                new Student( "Mariia", "Yarema", "Physics")
        ));
    }

    public List<Student> getAll() {
        return repository.findAll();
    }

    public Student getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public Student create(Student student) {
        return repository.save(student);
    }

    public Student update(Student student) {
        return repository.save(student);
    }
}
