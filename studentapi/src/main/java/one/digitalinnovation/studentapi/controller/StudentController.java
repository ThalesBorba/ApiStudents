package one.digitalinnovation.studentapi.controller;

import one.digitalinnovation.studentapi.dto.MessageResponseDTO;
import one.digitalinnovation.studentapi.entities.Student;
import one.digitalinnovation.studentapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }
}