package edu.yarema.security25.student;

/*
 * @author Mariia
 * @project security25
 * @class Student
 * @version 1.0.0
 * @since {DATE} - 12.38
 */

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Student {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String course;

    public Student(String firstName, String lastName, String course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Student student)) return false;

        return getId().equals(student.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
