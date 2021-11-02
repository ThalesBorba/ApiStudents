package one.digitalinnovation.studentapi.services;

import one.digitalinnovation.studentapi.mapper.StudentMapper;
import one.digitalinnovation.studentapi.dto.request.StudentDTO;
import one.digitalinnovation.studentapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.studentapi.entities.Student;
import one.digitalinnovation.studentapi.repository.StudentRepository;
import one.digitalinnovation.studentapi.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.studentapi.utils.StudentUtils.createFakeDTO;
import static one.digitalinnovation.studentapi.utils.StudentUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private StudentMapper studentMapper;

    @InjectMocks
    private StudentService studentService;

    @Test
    void testGivenStudentDTOThenReturnSuccessSavedMessage() {
        StudentDTO studentDTO = createFakeDTO();
        Student expectedSavedStudent = createFakeEntity();

        lenient().when(studentMapper.toModel(studentDTO)).thenReturn(expectedSavedStudent);
        when(studentRepository.save(any(Student.class))).thenReturn(expectedSavedStudent);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedStudent.getId());
        MessageResponseDTO successMessage = studentService.createStudent(studentDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Long savedStudentId) {
        return MessageResponseDTO.builder()
                .message("Created student with the ID " + savedStudentId)
                .build();
    }

}
