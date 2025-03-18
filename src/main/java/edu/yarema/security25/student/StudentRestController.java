package edu.yarema.security25.student;

import org.springframework.web.bind.annotation.RestController;

/*
 * @author Mariia
 * @project security25
 * @class StudentRestController
 * @version 1.0.0
 * @since {DATE} - 12.53
 */
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentRestController {

    private final StudentService service;

    @GetMapping
    public List<Student> getStudents() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Student getOneStudent(@PathVariable String id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return service.create(student);
    }

    @PutMapping
    public Student update(@RequestBody Student student) {
        return service.update(student);
    }
}
