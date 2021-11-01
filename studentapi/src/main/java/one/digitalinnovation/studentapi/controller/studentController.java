package one.digitalinnovation.studentapi.controller;

import one.digitalinnovation.studentapi.entities.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class studentController {

    @GetMapping
    public String getStudentsList() {
        return "API Test!";
    }
}
