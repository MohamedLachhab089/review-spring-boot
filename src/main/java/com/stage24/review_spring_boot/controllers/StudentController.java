package com.stage24.review_spring_boot.controllers;

import com.stage24.review_spring_boot.dtos.StudentDto;
import com.stage24.review_spring_boot.dtos.StudentResponseDto;
import com.stage24.review_spring_boot.entities.School;
import com.stage24.review_spring_boot.entities.Student;
import com.stage24.review_spring_boot.mappers.StudentMapper;
import com.stage24.review_spring_boot.repositories.StudentRepo;
import com.stage24.review_spring_boot.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/* @RestController simplifies RESTful service development by combining @Controller and
    @ResponseBody in one annotation */
@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponseDto saveStudent(@Valid @RequestBody StudentDto studentDto) {
        return studentService.saveStudent(studentDto);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> findAllStudent() {
        return studentService.findAllStudent();
    }

    @GetMapping("/students/search/{std-name}")
    public List<StudentResponseDto> findStudentByName(@PathVariable("std-name") String name) {
        return studentService.findStudentByName(name);
    }

    @GetMapping("/students/{std-id}")
    public StudentResponseDto findStudentById(@PathVariable("std-id") Integer stdId) {
        return studentService.findStudentById(stdId);
    }

    @DeleteMapping("/students/{std-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(@PathVariable("std-id") Integer stdId) {
        studentService.deleteStudentById(stdId);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        // Crée une map pour stocker les erreurs sous forme de clé-valeur (champ, message d'erreur)
        var errors = new HashMap<String, String>();
        exception.getBindingResult().getAllErrors().forEach(error -> {
            var fieldName = ((FieldError) error).getField();
            var errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    // here if you want to check and return the student deleted
    /*@DeleteMapping("/students/{std-id}")
    @ResponseStatus(HttpStatus.OK)
    public Student deleteStudentById(@PathVariable("std-id") Integer stdId) {
        Student student = studentRepo.findById(stdId).orElse(null);
        studentRepo.delete(student);
        return student;
    }*/
}

    /*@GetMapping("/hello")
    public String sayHello() {
        return "Hello Everyone";
    }*/




    /* @PostMapping("/post")
    public String post(@RequestBody String msg) {
        return "Hello Post for: " + msg;
    } */
//
//    @PostMapping("/post-order")
//    public String post(@RequestBody Order order) {
//        return "Hello Post for: " + order.toString();
//    }
//
//    @PostMapping("/post-order-record")
//    public String postRecord(@RequestBody OrderRecord orderRecord) {
//        return "Hello Post for: " + orderRecord.toString();
//    }
//
//    /* this how it looks like:
//     * http://localhost:8081/hello/mohamedlhb */
//    @GetMapping("/hello/{name}")
//    public String pathVariable(@PathVariable String name) {
//        return "Hello " + name;
//    }
//
//    // if you want to run this url "/hello" you should comment the first
//    // url in the line 9
//    /* this how it looks like:
//    * http://localhost:8081/hello?fname=med&lname=lhb */
//    @GetMapping("/hello")
//    public String reqVariable(@RequestParam String fname, @RequestParam String lname) {
//        return "Hello " + fname + lname;
//    }

/*    @GetMapping("/hello2")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sayHello2() {
        return "Hello 2 Everyone";
    }   */
