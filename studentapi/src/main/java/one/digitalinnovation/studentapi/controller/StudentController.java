package one.digitalinnovation.studentapi.controller;

import one.digitalinnovation.studentapi.dto.request.StudentDTO;
import one.digitalinnovation.studentapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.studentapi.entities.Student;
import one.digitalinnovation.studentapi.exceptions.StudentNotFoundException;
import one.digitalinnovation.studentapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

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
    public MessageResponseDTO createStudent(@RequestBody @Valid StudentDTO studentDTO) {
        return studentService.createStudent(studentDTO);
    }

    @GetMapping
    public List<StudentDTO> listAll() {
        return studentService.listAll();
    }

    @GetMapping("/{id}")
    public StudentDTO findById(@PathVariable Long id) throws StudentNotFoundException {
        return  studentService.findById(id);
    }

}