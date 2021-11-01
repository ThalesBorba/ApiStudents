package one.digitalinnovation.studentapi.service;

import one.digitalinnovation.studentapi.dto.request.StudentDTO;
import one.digitalinnovation.studentapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.studentapi.entities.Student;
import one.digitalinnovation.studentapi.exceptions.StudentNotFoundException;
import one.digitalinnovation.studentapi.mapper.StudentMapper;
import one.digitalinnovation.studentapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    private final StudentMapper studentMapper = StudentMapper.INSTANCE;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public MessageResponseDTO createStudent(StudentDTO studentDTO) {
        Student studentToSave = studentMapper.toModel(studentDTO);
        Student savedStudent = studentRepository.save(studentToSave);
        return MessageResponseDTO
                .builder()
                .message("Created student with ID " + savedStudent.getId())
                .build();
    }

    public List<StudentDTO> listAll() {
        List<Student> allStudents = studentRepository.findAll();
        return allStudents.stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public StudentDTO findById(Long id) throws StudentNotFoundException {
        Student student = verifyIfExists(id);
        return studentMapper.toDTO(student);
    }

    public void delete(Long id) throws StudentNotFoundException {
        verifyIfExists(id);
        studentRepository.deleteById(id);
    }

    private Student verifyIfExists(Long id) throws StudentNotFoundException {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }
}
