package one.digitalinnovation.studentapi.repository;

import one.digitalinnovation.studentapi.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
