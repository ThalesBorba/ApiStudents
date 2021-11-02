package one.digitalinnovation.studentapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.studentapi.entities.Evaluation;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 15)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 15)
    private String lastName;

    @NotEmpty
    @Size(min = 7, max = 8)
    private String matricula;

    private String birthDate;

    @NotEmpty
    @Valid
    private List<EvaluationDTO> evaluations;

}
