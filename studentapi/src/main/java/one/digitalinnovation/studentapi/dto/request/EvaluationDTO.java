package one.digitalinnovation.studentapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.studentapi.enums.GradeType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    private GradeType gradeType;

    @NotEmpty
    @Size(min = 1, max = 2)
    private Long grade;
}
