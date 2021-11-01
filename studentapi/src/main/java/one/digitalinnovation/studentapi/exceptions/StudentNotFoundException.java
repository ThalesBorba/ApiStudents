package one.digitalinnovation.studentapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(Long id) {
        super("No student found with the id " + id);
    }
}
