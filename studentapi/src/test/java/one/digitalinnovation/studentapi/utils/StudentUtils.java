package one.digitalinnovation.studentapi.utils;

import one.digitalinnovation.studentapi.dto.request.StudentDTO;
import one.digitalinnovation.studentapi.entities.Student;

import java.time.LocalDate;
import java.util.Collections;

public class StudentUtils {

    private static final String FIRST_NAME = "Thales";
    private static final String LAST_NAME = "Borba";
    private static final String MATRICULA = "20210001";
    private static final long STUDENT_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2001, 1, 1);

    public static StudentDTO createFakeDTO() {
        return StudentDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .matricula(MATRICULA)
                .birthDate("01-01-2001")
                .evaluations(Collections.singletonList(EvaluationUtils.createFakeDTO()))
                .build();
    }

    public static Student createFakeEntity() {
        return Student.builder()
                .id(STUDENT_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .matricula(MATRICULA)
                .birthDate(BIRTH_DATE)
                .evaluations(Collections.singletonList(EvaluationUtils.createFakeEntity()))
                .build();
    }




}
