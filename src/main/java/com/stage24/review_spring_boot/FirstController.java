package com.stage24.review_spring_boot;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* @RestController simplifies RESTful service development by combining @Controller and
    @ResponseBody in one annotation */
@RestController
public class FirstController {

    private final StudentRepo studentRepo;

    public FirstController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @PostMapping("/students")
    public Student post(@RequestBody Student student) {
        return studentRepo.save(student);
    }

    @GetMapping("/students")
    public List<Student> findAllStudent() {
        return studentRepo.findAll();
    }

    @GetMapping("/students/search/{std-name}")
    public List<Student> findStudentByName(@PathVariable("std-name") String name) {
        return studentRepo.findAllByNameContaining(name);
    }

    @GetMapping("/students/{std-id}")
    public Student findStudentById(@PathVariable("std-id") Integer stdId) {
        return studentRepo.findById(stdId).orElse(null);
    }

    @DeleteMapping("/students/{std-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(@PathVariable("std-id") Integer stdId) {
        studentRepo.deleteById(stdId);
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
