package one.digitalinnovation.studentapi.service;

import one.digitalinnovation.studentapi.dto.MessageResponseDTO;
import one.digitalinnovation.studentapi.entities.Student;
import one.digitalinnovation.studentapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public MessageResponseDTO createStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        return MessageResponseDTO
                .builder()
                .message("Created student with ID " + savedStudent.getId())
                .build();
    }
}
