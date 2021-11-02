package one.digitalinnovation.studentapi.utils;

import one.digitalinnovation.studentapi.dto.request.EvaluationDTO;
import one.digitalinnovation.studentapi.entities.Evaluation;
import one.digitalinnovation.studentapi.enums.GradeType;

public class EvaluationUtils {

    private static final long GRADE = 10;
    private static final GradeType GRADE_TYPE = GradeType.FIRSTTERM;
    private static final long EVALUATION_ID = 1L;

    public static EvaluationDTO createFakeDTO() {
        return EvaluationDTO.builder()
                .grade(GRADE)
                .gradeType(GRADE_TYPE)
                .build();
    }

    public static Evaluation createFakeEntity() {
        return Evaluation.builder()
                .id(EVALUATION_ID)
                .grade(GRADE)
                .gradeType(GRADE_TYPE)
                .build();
    }
}