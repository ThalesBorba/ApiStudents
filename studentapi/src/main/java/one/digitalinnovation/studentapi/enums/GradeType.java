package one.digitalinnovation.studentapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GradeType {

    FIRSTSEMESTER("First semester grade"),
    SECONDSEMESTER("Second semester grade"),
    THIRDSEMESTER("Third semester grade"),
    FOURTHSEMESTER("Fourth semester grade"),
    RETAKE("Retake Test"),
    FINALSCORE("Final score");

    private final String description;
}
