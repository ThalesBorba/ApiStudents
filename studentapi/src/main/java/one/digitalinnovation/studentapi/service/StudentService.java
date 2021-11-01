package one.digitalinnovation.studentapi.service;

import one.digitalinnovation.studentapi.dto.request.StudentDTO;
import one.digitalinnovation.studentapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.studentapi.entities.Student;
import one.digitalinnovation.studentapi.entities.StudentDTO;
import one.digitalinnovation.studentapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public MessageResponseDTO createStudent(StudentDTO studentDTO) {
        Student studentToSave = Student.builder()
                .firstName(studentDTO.getFirstName())
                .build();
        StudentDTO savedStudent = studentRepository.save(studentDTO);
        return MessageResponseDTO
                .builder()
                .message("Created student with ID " + savedStudent.getId())
                .build();
    }
}
