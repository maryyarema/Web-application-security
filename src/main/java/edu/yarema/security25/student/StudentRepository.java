package edu.yarema.security25.student;

/*
 * @author Mariia
 * @project security25
 * @class ItemRepository
 * @version 1.0.0
 * @since {DATE} - 12.47
 */
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
}


