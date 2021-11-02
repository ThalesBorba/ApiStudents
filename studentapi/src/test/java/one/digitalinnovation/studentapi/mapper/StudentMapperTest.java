package one.digitalinnovation.studentapi.mapper;

import one.digitalinnovation.studentapi.mapper.StudentMapper;
import one.digitalinnovation.studentapi.dto.request.StudentDTO;
import one.digitalinnovation.studentapi.dto.request.EvaluationDTO;
import one.digitalinnovation.studentapi.entities.Student;
import one.digitalinnovation.studentapi.entities.Evaluation;
import one.digitalinnovation.studentapi.utils.StudentUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    void testGivenStudentDTOThenReturnStudentEntity() {
        StudentDTO studentDTO = StudentUtils.createFakeDTO();
        Student student = studentMapper.toModel(studentDTO);

        assertEquals(studentDTO.getFirstName(), student.getFirstName());
        assertEquals(studentDTO.getLastName(), student.getLastName());
        assertEquals(studentDTO.getMatricula(), student.getMatricula());

        Evaluation evaluation = student.getEvaluations().get(0);
        EvaluationDTO evaluationDTO = studentDTO.getEvaluations().get(0);

        assertEquals(evaluationDTO.getGradeType(), evaluation.getGradeType());
        assertEquals(evaluationDTO.getGrade(), evaluation.getGrade());
    }

    @Test
    void testGivenStudentEntityThenReturnStudentDTO() {
        Student student = StudentUtils.createFakeEntity();
        StudentDTO studentDTO = studentMapper.toDTO(student);

        assertEquals(student.getFirstName(), studentDTO.getFirstName());
        assertEquals(student.getLastName(), studentDTO.getLastName());
        assertEquals(student.getMatricula(), studentDTO.getMatricula());

        Evaluation evaluation = student.getEvaluations().get(0);
        EvaluationDTO evaluationDTO = studentDTO.getEvaluations().get(0);

        assertEquals(evaluation.getGradeType(), evaluationDTO.getGradeType());
        assertEquals(evaluation.getGrade(), evaluationDTO.getGrade());
    }
}
