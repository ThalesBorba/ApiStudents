package one.digitalinnovation.studentapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GradeType {

    FIRSTTERM("First semester grade"),
    SECONDTERM("Second semester grade"),
    THIRDTERM("Third semester grade"),
    FOURTHTERM("Fourth semester grade"),
    RETAKE("Retake Test"),
    FINALSCORE("Final score");

    private final String description;
}
