package edu.yarema.security25.student;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/students")
public class StudentRestController {

    private final StudentService service;
    private final Map<String, String> helloMessages = new HashMap<>();

    public StudentRestController(StudentService service) {
        this.service = service;
        // Додаємо стандартні привітання
        helloMessages.put("user", "Hello User!");
        helloMessages.put("admin", "Hello Admin!");
        helloMessages.put("unknown", "Hello Unknown!");
    }

    // CRUD операції для студентів
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

    // CRUD операції для привітань
    @GetMapping("/hello/{role}")
    public String getHelloMessage(@PathVariable String role) {
        return helloMessages.getOrDefault(role, "Hello " + role + "!");
    }

    @PostMapping("/hello/{role}")
    public String createHelloMessage(@PathVariable String role, @RequestBody String message) {
        helloMessages.put(role, message);
        return "Message for " + role + " created!";
    }

    @PutMapping("/hello/{role}")
    public String updateHelloMessage(@PathVariable String role, @RequestBody String message) {
        if (helloMessages.containsKey(role)) {
            helloMessages.put(role, message);
            return "Message for " + role + " updated!";
        }
        return "Role not found!";
    }

    @DeleteMapping("/hello/{role}")
    public String deleteHelloMessage(@PathVariable String role) {
        if (helloMessages.containsKey(role)) {
            helloMessages.remove(role);
            return "Message for " + role + " deleted!";
        }
        return "Role not found!";
    }
}
